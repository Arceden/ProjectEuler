import java.math.BigInteger;

public class Problem020 implements Problem {

    public static void main(String[] args) {
        Problem problem = new Problem020();
        problem.solve();
    }

    @Override
    public void solve() {
        BigInteger i = factorial(100);
        BigInteger sum = BigInteger.ZERO;

        System.out.println(i);
        while(i.compareTo(BigInteger.ZERO) == 1) {
            sum = sum.add(i.mod(BigInteger.valueOf(10)));
            i = i.divide(BigInteger.valueOf(10));
        }

        System.out.println("Sum of all digits: "+sum);
    }

    /**
     * Factorial 100! is far to long for a normal Integer or Long. It has to be done with BigInteger
     * @param n Factorial starting point
     * @return BigInteger result
     */
    private BigInteger factorial(int n) {
        if (n == 1)
            return BigInteger.ONE;

        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }
}
