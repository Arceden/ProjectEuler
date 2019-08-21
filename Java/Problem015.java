import java.math.BigInteger;

public class Problem015 implements Problem {

    //Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
    //How many such routes are there through a 20×20 grid?

    public static void main(String[] args) {
        new Problem015().solve();
    }

    @Override
    public void solve() {
        int grid_size = 20;

        //Print the answer
        System.out.println(calculateCombanations(BigInteger.valueOf(grid_size)));

    }

    private long calculateCombanations(int n){

        //               n!
        // C(n,r) = ------------ = answer
        //           (r!(n-r)!)

        return factorial(n*2) / (factorial(n) * factorial(n*2 - n));

    }

    private BigInteger calculateCombanations(BigInteger n){

        //               n!
        // C(n,r) = ------------ = answer
        //           (r!(n-r)!)

        return factorial(n.multiply(BigInteger.valueOf(2))).divide(factorial(n).multiply(factorial(n.multiply(BigInteger.valueOf(2)).add(n.subtract(n.multiply(BigInteger.valueOf(2)))))));

    }


    /**
     * Factorial function for long datatypes
     * @param num long
     * @return num! BigInteger
     */
    private long factorial(long num){
        if(num<=1)return 1;
        return num*factorial(num-1);
    }

    /**
     * Factorial function for BigInteger datatypes
     * @param num BigInteger
     * @return num! BigInteger
     */
    private BigInteger factorial(BigInteger num){
        if(num.compareTo(BigInteger.ONE) == 0)return BigInteger.valueOf(1);
        return num.multiply(factorial(num.add(BigInteger.valueOf(-1))));
    }

}
