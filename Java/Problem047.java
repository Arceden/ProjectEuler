/*
    The first two consecutive numbers to have two distinct prime factors are:
        14 = 2 × 7
        15 = 3 × 5
    The first three consecutive numbers to have three distinct prime factors are:
        644 = 2² × 7 × 23
        645 = 3 × 5 × 43
        646 = 2 × 17 × 19.
    Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */

import java.util.HashSet;

public class Problem047 implements Problem {
    public static void main(String[] args) {
        new Problem047().solve();
    }

    @Override
    public void solve() {
        printArray(findConsecutivePrimeCount(2));
        printArray(findConsecutivePrimeCount(3));
        printArray(findConsecutivePrimeCount(4));
    }

    private void printArray(int[] arr) {
        for (int i: arr)
            System.out.print(i + " ");
        System.out.println("");
    }

    private int[] findConsecutivePrimeCount(int amount) {
        int[] list = new int[amount];

        int i = 2;
        int combo = 0;
        while (combo < amount) {
            HashSet<Integer> f = factors(i);
            if (f.size() == amount) {
                list[combo] = i;
                combo++;
            } else if (combo != 0) {
                combo = 0;
            }
            ++i;

            if (i < 0)
                System.out.println("OVERFLOW");
        }

        return list;
    }

    private HashSet<Integer> factors(int n) {
        HashSet<Integer> set = new HashSet<>();

        int divisor = 2;
        while (n>1 && n >= divisor) {
            if (n % divisor == 0) {
                set.add(divisor);
                n/=divisor;
            }
            else {
                if (divisor == 2)
                    divisor++;
                else
                    divisor += 2;
                while (!isPrime(divisor)) {divisor += 2;}
            }
        }

        return set;
    }

    private boolean isPrime(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        for (int i=3; i * i <= n; i+=2)
            if (n % i == 0)
                return false;

        return true;
    }
}
