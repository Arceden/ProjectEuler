import java.math.BigInteger;

/*
    The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
    Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */
public class Problem048 implements Problem {
    public static void main(String[] args) {
        new Problem048().solve();
    }

    @Override
    public void solve() {
        int limit = 1000;
        BigInteger sum = BigInteger.ZERO;

        for (int i=1; i<=limit; i++)
            sum = sum.add(selfPower(i));

        System.out.println(sum.toString().substring(sum.toString().length()-10));
    }

    private BigInteger selfPower(int n) {
        BigInteger sum = BigInteger.valueOf(n);
        sum = sum.pow(n);
        return sum;
    }
}
