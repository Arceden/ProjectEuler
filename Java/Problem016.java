import java.math.BigInteger;

public class Problem016 implements Problem {

    //2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    //What is the sum of the digits of the number 2^1000?

    public static void main(String[] args) {
        new Problem016().solve();
    }

    @Override
    public void solve() {
        BigInteger num = goPow(2,1000);              //Big integer has to be used since long is too small
        long sum = 0;                                       //A sum is needed for later

        String tmp = num.toString();                        //Make it into a string so we can use substring
        for(int x=0;x<tmp.length();x++){                    //Loop through every number
            sum+=Integer.parseInt(tmp.substring(x,x+1));    //Add the number to the sum
        }

        //Print the answer
        System.out.println(sum);
    }

    /**
     * We need to have our own Pow function since we are going to use a BigInteger.
     * @param n Base number
     * @param m Power or "Macht" in dutch
     * @return BigInteger
     */
    private BigInteger goPow(int n, int m){

        BigInteger sum = BigInteger.valueOf(n);
        for(int x=1;x<m;x++){
            sum = sum.multiply(BigInteger.valueOf(n));
        }

        return sum;
    }

}
