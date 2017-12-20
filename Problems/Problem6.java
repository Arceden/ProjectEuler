package Problems;

/**
 * Created by Arnold on 20-12-2017.
 */
public class Problem6 extends Functions {

    //The sum of the squares of the first ten natural numbers is,
    //  1^2 + 2^2 + ... + 10^2 = 385
    //
    //The square of the sum of the first ten natural numbers is,
    //  (1 + 2 + ... + 10)2 = 552 = 3025
    //
    //Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
    //Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

    int natural_numbers = 100;

    public Problem6(){

        //Make the "Sum of the squares"
        int susq = 0;
        for(int x=1;x<=natural_numbers;x++){
            susq+=Math.pow(x,2);
        }

        //Make the "Square of the sum"
        int sqsu = 0;
        for(int x=1;x<=natural_numbers;x++){
            sqsu+=x;
        }
        sqsu=(int)Math.pow(sqsu,2);

        print(sqsu-susq);


    }

}
