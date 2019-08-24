import java.math.BigInteger;
import java.util.*;

public class Problem029 implements Problem {

    public static void main(String[] args) {
        new Problem029().solve();
    }

    @Override
    public void solve() {
        final int LOW = 2;
        final int HIGH = 100;

        ArrayList<BigInteger> list = new ArrayList<>();

        for (int x=LOW; x<=HIGH; x++) {
            for (int y=LOW; y<=HIGH; y++) {
                BigInteger a = BigInteger.valueOf(x);
                a = a.pow(y);
                list.add(a);
            }
        }

        // Make it a set to make sure we only have unique values
        HashSet<BigInteger> set = new HashSet<>(list);
        System.out.println(set.size());
    }
}

