/*
The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:
    1! + 4! + 5! = 1 + 24 + 120 = 145
Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:
    169 → 363601 → 1454 → 169
    871 → 45361 → 871
    872 → 45362 → 872
It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
    69 → 363600 → 1454 → 169 → 363601 (→ 1454)
    78 → 45360 → 871 → 45361 (→ 871)
    540 → 145 (→ 145)
Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.
How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
*/

import java.util.LinkedList;

public class Problem074 implements Problem {
    private final int DEPTH = 60;

    public static void main(String[] args) {
        new Problem074().solve();
    }

    @Override
    public void solve() {
        int sum = 0;
        for (int i=0; i<1000000; i++)
            if (chainLength(i) == 60)
                ++sum;

        System.out.println("Sum: " + sum);
    }

    int chainLength(int n) {
        long query = n;
        LinkedList<Long> hits = new LinkedList<>();
        hits.add(query);

        for (int i=1; i<=DEPTH; i++) {
            query = factorialDigitSum(query);

            if (hits.contains(query))
                return i;

            hits.add(query);
        }

        return 0;
    }

    long factorialDigitSum(long n) {
        if (n<=0)
            return 0;

        return getFactorial(n%10) + factorialDigitSum(n/10);
    }

    long getFactorial(long n) {
        if (n <= 1)
            return 1;

        return n * getFactorial(n-1);
    }
}
