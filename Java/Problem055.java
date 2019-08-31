import java.math.BigInteger;

public class Problem055 implements Problem {
    public static void main(String[] args) {
        new Problem055().solve();
    }

    @Override
    public void solve() {
        int sum = 0;

        for (int i=0; i<10000; i++)
            if (!lychrel(i))
                sum++;

        System.out.println(sum);
    }

    private boolean lychrel(int n) {
        return lychrel(BigInteger.valueOf(n), 50);
    }

    private boolean lychrel(BigInteger n, int depth) {
        if (depth != 50 && isPalindrome(n))
            return true;

        if (depth == 0)
            return false;

        return lychrel(combineReversal(n), --depth);
    }

    private boolean isPalindrome(BigInteger n) {
        if (n.compareTo(BigInteger.TEN) == -1)
            return true;

        if (firstDigit(n).equals(n.mod(BigInteger.TEN)))
            return isPalindrome(removeFirstDigit(n).divide(BigInteger.TEN));

        return false;
    }

    private BigInteger firstDigit(BigInteger n) {
        if (n.compareTo(BigInteger.TEN) == -1)
            return n.mod(BigInteger.TEN);

        return firstDigit(n.divide(BigInteger.TEN));
    }

    private BigInteger removeFirstDigit(BigInteger n) {
        if (n.compareTo(BigInteger.TEN) == -1)
            return BigInteger.ZERO;

        BigInteger i = n.mod(BigInteger.TEN);

        return  i.add(removeFirstDigit(n.divide(BigInteger.TEN)).multiply(BigInteger.TEN));
    }

    private BigInteger combineReversal(BigInteger n) {
        return n.add(reverseInteger(n));
    }

    private BigInteger reverseInteger(BigInteger n) {
        BigInteger r = BigInteger.ZERO;
        while (n.compareTo(BigInteger.ZERO) == 1) {
            r = r.multiply(BigInteger.TEN);
            r = r.add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }

        return r;
    }
}
