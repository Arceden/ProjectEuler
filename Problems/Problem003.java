package Problems;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem003 extends Functions {

    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143 ?

//    long number = 13195L;
    long number = 600851475143L;
    long counter = 2L;
    boolean finished = false;

    public Problem003(){

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

        print(primes.get(primes.size()-1));

    }

}
