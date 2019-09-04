import java.util.HashSet;

public class Problem032 implements Problem {
    public static void main(String[] args) {
        new Problem032().solve();
    }

    @Override
    public void solve() {

        int sum = 0;

        HashSet<Long> knownProducts = new HashSet<>();
        for (int multiplicand=1; multiplicand<500000000; multiplicand++) {
            for (int multiplier = multiplicand + 1; multiplier < 500000000/multiplicand; multiplier++) {
                long product = multiplicand*multiplier;

                if (knownProducts.contains(product))
                    continue;

                if (isPandigital(multiplicand, multiplier, multiplicand*multiplier)) {
                    knownProducts.add(product);
                    sum += multiplicand * multiplier;
                }
            }
        }

        System.out.println(sum);
    }

    boolean isPandigital(int multiplicand, int multiplier, int product) {
        String s = multiplicand + "" + multiplier + "" + product;
        if (s.length() != 9)
            return false;

        return isPandigital(Integer.parseInt(s));
    }

    boolean isPandigital(int n) {
        HashSet<Integer> set = new HashSet<>();

        // Add as unique items into the set
        while (n > 0) {
            int i = n % 10;
            if (set.contains(i))
                return false;

            set.add(i);
            n/=10;
        }

        // Query
        int q = 1;
        for (Integer i: set) {
            if (i != q)
                return false;

            q++;
        }

        return true;
    }
}
