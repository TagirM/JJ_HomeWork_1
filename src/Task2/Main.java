package Task2;

//   * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
//           * 2.1 Создать список из 10-20 сотрудников
//           * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
//           * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
//           * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
//           * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        Создать список из 10-20 сотрудников
         */
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Oleg", 22, 1000, "HR"));
        employees.add(new Employee("Ivan", 23, 1500, "HR"));
        employees.add(new Employee("Artem", 24, 1100, "IT"));
        employees.add(new Employee("Olga", 35, 10000, "Finance"));
        employees.add(new Employee("Elena", 45, 12000, "Management"));
        employees.add(new Employee("Nataliya", 40, 7000, "HR"));
        employees.add(new Employee("Semen", 26, 2000, "HR"));
        employees.add(new Employee("Inna", 37, 11000, "Management"));
        employees.add(new Employee("Sergey", 25, 1800, "HR"));
        employees.add(new Employee("Ivan", 30, 5000, "IT"));
        employees.add(new Employee("Polina", 33, 7000, "IT"));
        employees.add(new Employee("Katya", 25, 4000, "IT"));
        employees.add(new Employee("Denis", 27, 3500, "Transport"));
        employees.add(new Employee("Oleg", 35, 4300, "Transport"));
        employees.add(new Employee("Anna", 27, 2100, "HR"));

        /*
        Вывести список всех различных отделов (department) по списку сотрудников
         */
        Set<String> departments = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(departments);

        /*
        Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
         */
        employees = employees.stream().peek(employee -> {
            if (employee.getSalary()<10000){
                employee.setSalary(employee.getSalary()*1.2);
            }
        }).toList();
        System.out.println(employees);//TODO remove

        /*
        Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
         */
        Map<String, List<Employee>> mapDepartments = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(mapDepartments);

        /*
        Из списка сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
         */
        Map<String, Double> departmentsSalary = mapDepartments.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                v -> v.getValue().stream().mapToDouble(Employee::getSalary).summaryStatistics().getAverage()));
        System.out.println(departmentsSalary);
    }
}
