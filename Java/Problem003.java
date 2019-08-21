import java.math.BigInteger;
import java.util.ArrayList;

public class Problem003 implements Problem {

    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143 ?

    long number = 600851475143L;
    long counter = 2L;
    boolean finished = false;

    public static void main(String[] args) {
        new Problem003().solve();
    }

    @Override
    public void solve() {
        long n = number;
        ArrayList<Long> primes = new ArrayList<>();

        while(!finished){

            if(n%counter==0){
                n/=counter;
                primes.add(counter);
            } else {
                counter++;
            }

            if(n<2||counter>=number)finished=true;
        }

        System.out.println(primes.get(primes.size()-1));
    }
}
