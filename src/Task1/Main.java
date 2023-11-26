package Task1;
//1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
//        * 1.1 Найти максимальное
//        * 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
//        * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        Создание списка из 1_000 рандомных чисел от 1 до 1_000_000
        */
        List<Long> listNumber = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listNumber.add(new Random().nextLong(1000000));
        }
        System.out.println(listNumber);//TODO remove
        /*
        Найти максимальное число коллекции и вывести
        */
        long max = listNumber.stream().max(Long::compareTo).get();
        System.out.println(max);

        /*
        Найти все числа больше 500_000 в коллекции, умножить на 5, отнять от них 150 и просуммировать и вывести
         */
        long sumNumber = listNumber.stream().filter(elem -> elem>500000).map(elem -> ((elem*5) - 150)).mapToLong(elem -> elem).sum();
        System.out.println(sumNumber);

        /*
        Найти количество чисел, квадрат которых меньше, чем 100_000 и вывести
         */
        List<Long> list = listNumber.stream().map(elem -> elem*elem).filter(elem -> elem<100000).toList();//TODO remove
        System.out.println(list);//TODO remove
        long countNumber = listNumber.stream().map(elem -> elem*elem).filter(elem -> elem<100000).count();
        System.out.println(countNumber);

    }
}
