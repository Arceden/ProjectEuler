package Problems;

/**
 * Created by Arnold on 20-12-2017.
 */
public class Problem009 extends Functions {

    //A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    //
    //a^2 + b^2 = c^2
    //For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
    //
    //There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    //Find the product abc.

    public Problem009(){

        final int sum = 1000;
        int a, b, c;

        for(a=1;a<sum/3;a++){
            for(b=1;b<sum/2;b++){
                c = sum-a-b;
                if(a*a+b*b==c*c){
                    print(a*b*c);
                    return;
                }
            }
        }


    }

}
