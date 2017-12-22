package Problems;

/**
 * Created by Arnold on 20-12-2017.
 */
public class Problem007 extends Functions {

    //By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    //What is the 10001st prime number?

    public Problem007(){

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
        print(x);

    }

}
