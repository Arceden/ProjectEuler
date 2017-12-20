package Problems;

public class Problem10 extends Functions {

    //The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    //Find the sum of all the primes below two million.

    public Problem10(){

        int limit = 2000000;        //A limit so that there wont be a prime above two million
        long sum = 0;               //The sum variable

        for(int x=2;x<limit;x++){   //Loop through all the numbers until two million

            if(isPrime(x)){         //Is it a prime?
                sum+=x;             //Add it to the sum
            }

        }

        //Print the answer
        print(sum);

    }

}
