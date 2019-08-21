package Classes;

import java.math.BigInteger;

public class Fibonacci {

    public int term;

    private int prev;
    private int number;

    BigInteger bigPrev;
    BigInteger bigNumber;


    public Fibonacci() {
        term = 0;

        number = 0;
        bigNumber = BigInteger.ZERO;

        prev = 1;
        bigPrev = BigInteger.ONE;
    }

    /**
     * Find the next number in the Fibonacci sequence
     * @return Integer - Result from the Fibonacci sequence
     */
    public int next() {
        term++;

        if (term == 1 || term == 2) {
            number = 1;
        } else {
            int tmp = number;
            number = number + prev;
            prev = tmp;
        }

        return number;
    }

    /**
     * Find the next BigInteger in the Fibonacci sequence
     * @return BigInteger - Result from the Fibonacci sequence
     */
    public BigInteger nextBig() {
        term++;

        if (term == 1 || term == 2) {
            bigNumber = BigInteger.ONE;
        } else {
            BigInteger tmp = bigNumber;
            bigNumber = bigNumber.add(bigPrev);
            bigPrev = tmp;
        }

        return bigNumber;
    }

    @Override
    public String toString() {
        return bigNumber.toString();
    }
}
