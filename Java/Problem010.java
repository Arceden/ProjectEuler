public class Problem010 implements Problem {

    //The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    //Find the sum of all the primes below two million.

    public static void main(String[] args) {

    }

    @Override
    public void solve() {
        int limit = 2000000;        //A limit so that there wont be a prime above two million
        long sum = 0;               //The sum variable

        for(int x=2;x<limit;x++){   //Loop through all the numbers until two million

            if(isPrime(x)){         //Is it a prime?
                sum+=x;             //Add it to the sum
            }

        }

        //Print the answer
        System.out.println(sum);
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
