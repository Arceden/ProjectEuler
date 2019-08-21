/**
 * Created by Arnold on 22-12-2017.
 */
public class Problem014 implements Problem {

    //The following iterative sequence is defined for the set of positive integers:
    //
    //n → n/2 (n is even)
    //n → 3n + 1 (n is odd)
    //
    //Using the rule above and starting with 13, we generate the following sequence:
    //
    //        13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    //It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
    //
    //Which starting number, under one million, produces the longest chain?
    //
    //NOTE: Once the chain starts the terms are allowed to go above one million.

    public static void main(String[] args) {
        new Problem014().solve();
    }

    @Override
    public void solve() {
        int highscore=0;                    //This will be the highscore for terms
        int highestStartingNum=0;           //This will be the starting number which gets the most terms
        int max=1000000;                    //Maximum amount of starting numbers to try

        for(int x=13;x<max;x++){
            int terms = getCollatzTerms(x);
            if(terms>highscore){
                highscore=terms;
                highestStartingNum=x;
            }
        }

        //Print the answer
        System.out.println(highestStartingNum);
    }

    private int getCollatzTerms(long num){

        int terms = 0;      //Count the amount of terms.

        while(num>1){       //Initial loop until the 1 has been hit

            if(num%2==0){   //Even
                num/=2;
            } else {        //Odd
                num*=3;
                num+=1;
            }

            terms++;        //Another term has been done, so plus 1

        }

        return terms;       //Return the amount of terms

    }

}
