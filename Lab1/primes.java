package Primes;

import java.util.ArrayList;

public class primes {
    public static void main(String[] args) {
        int count = 4; //начинаем с 4, т.к. до 10 нам известны все простые числа и программа их не обрабатывает.
        int n = 100; //число до которого необходимо найти все простые числа
        ArrayList<Integer> numbers = new ArrayList<>(); //создаем массив, необходим для вывода чисел на экран
        numbers.add(2); //добавляем в массив простые числа до 10
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);

        for (int i = 11; i <= n; i+=2) {
            if (isPrime(i)) {
                numbers.add(i);
            }
        }

        System.out.print(numbers);

    }

    static boolean isPrime(int a) {
        int p = 0;
        if ((a % 2 == 0)||(a%10==5)) {
            return false;
        }
        else {
             for (int j = 3; j <= Math.sqrt(a); j += 2) { //делим на все нечетные числа до корня из i
                if (a % j == 0) { // если хотя бы на одно число делится, то остановка цикла, переход к следующему числу
                    p += 1; break;
                }
            }
        }
        if (p > 0) {
            return false;
        } else return true;

    }
}
