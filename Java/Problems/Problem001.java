package Problems;

import java.util.ArrayList;

/**
 * Created by Arnold on 11-9-2017.
 */
public class Problem001 extends Functions {

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    //The sum of these multiples is 23
    //
    //Find the sum of all the multiples of 3 or 5 below 1000.

    protected int max = 1000;
    protected int sum = 0;
    protected ArrayList<Integer> numbers = new ArrayList<Integer>();

    public Problem001(){

        //Place numbers
        numbers.add(3);
        numbers.add(5);

        //Initial loop
        for(int x=1;x<this.max;x++){
            //Loop through the numbers
            for(int i=0;i<numbers.size();i++){
                //Is itterator in the table of the number?
                if((x%numbers.get(i))==0){
                    //Add it into the sum
                    sum+=x;
                    break;
                }
            }
        }

        //Print the solution
        print(sum);

    }

}
