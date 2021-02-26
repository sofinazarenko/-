package Primes;

import java.util.ArrayList;

public class primes {
    public static void main(String[] args) {
        int count = 4;
        int n = 100;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);

        for (int i = 11; i <= n; i+=2) {
            if (isPrime(i)) {
                count++;
                numbers.add(i);
            }
        }

        System.out.println("The number of prime numbers: " + count);
        System.out.print(numbers);

    }

    static boolean isPrime(int a) {
        int p = 0;
        if ((a % 2 == 0)||(a%10==5)) {
            return false;
        }
        else {
            for (int j = 3; j <= Math.sqrt(a); j += 2) {
                if (a % j == 0) {
                    p += 1; break;
                }
            }
        }
        if (p > 0) {
            return false;
        } else return true;


    }
}
