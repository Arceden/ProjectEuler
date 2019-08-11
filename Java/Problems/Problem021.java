package Problems;

import java.util.HashMap;
import java.util.LinkedList;

/**
 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.
 */

public class Problem021 implements Problem {

    public static void main(String[] args) {
        new Problem021().solve();
    }

    @Override
    public void solve() {
        int solution = 0;

        // Hash map is quick for access, i think
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<10000; i++) {
            // Store entry
            int sum = d(i);

            // Add to the map
            map.put(i, sum);

            // The number 6 has 6 divisors, i don't think this counts
            if (sum == i)
                continue;

            // Stop if needed
            if (sum > i)    // There cant be an entry in the map if the sum is greater than the current _n_
                continue;

            // Check if sum is in map
            int query = map.get(sum);
            if (query == 0) // Not found
                continue;

            // Amicable numbers
            if (i != query)
                continue;

            // Give clear overview
            System.out.println("Comparing\t|\t" + i + "\t" + sum);
            System.out.println("Sums\t\t|\t" + sum + "\t" + query+"\n");
            solution += i;
            solution += sum;
        }

        System.out.println("Solution: "+solution);
    }

    // Sum of divisors
    int d(int n) {
        LinkedList<Integer> l = divisors(n);
        int sum = 0;

        while (l.size() != 0)
            sum += l.pop();

        return sum;
    }

    LinkedList<Integer> divisors(int n) {
        LinkedList<Integer> l = new LinkedList<>();

        for (int i=n/2; i>0; i--)
            if (n%i==0)
                l.add(i);

        return l;
    }
}
