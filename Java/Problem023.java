import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class Problem023 implements Problem {

    ArrayList<Integer> abundants = new ArrayList<>();

    public static void main(String[] args) {
        new Problem023().solve();
    }

    @Override
    public void solve() {
        int limit = 28123;
        int sum = 0;

        for(int i=0; i<=limit; i++) {
            // Is it abundant?
            if (isAbundant(i)) {
                abundants.add(i);
            }

            // If it can be written as the sum of two abundant numbers, do not add it to the sum
            if (canBeSumOfTwoAbundantNumbers(i)) {
                continue;
            }

            sum += i;
        }

        // Solution
        System.out.println(sum);
    }

    /** Calculate if the provided number can be created as the sum of two abundant numbers */
    private boolean canBeSumOfTwoAbundantNumbers(int n) {
        for (int i=0; i<abundants.size(); i++) {
            for (int x=i; x<abundants.size(); x++) {
                if (abundants.get(i) + abundants.get(x) == n)
                    return true;
            }
        }

        return false;
    }

    /** Check if the current number is abundant */
    private boolean isAbundant(int n) {
        return divisorsSum(n) > n;
    }

    /** Get all divisors in a LinkedList */
    private int divisorsSum(int n) {
        int sum = 0;

        for (int i=n/2; i>0; i--)
            if (n%i==0)
                sum += i;

        return sum;
    }
}
