/**
 * Created by Arnold on 20-12-2017.
 */
public class Problem007 implements Problem {

    //By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    //What is the 10001st prime number?

    public static void main(String[] args) {
        new Problem007().solve();
    }

    @Override
    public void solve() {
        int x = 1;              //This integer is what will be check if it is or isnt a prime
        int print_nth = 0;      //This integer counts up when a prime has been found
        int target_num = 10001; //This is the target number which the code has to find
        boolean hit = false;    //This becomes true when the target number has been "hit"

        while(!hit){
            x++;                //Just count up
            if(isPrime(x)){     //If integer x is a prime
                print_nth++;
                if(print_nth==target_num)hit=true;  //If the integer print_nth has reached the target_num, hit becomes true
            }
        }

        //Print the answer
        System.out.println(x);

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
