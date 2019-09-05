import java.util.HashSet;

public class Problem038 implements Problem {
    public static void main(String[] args) {
        new Problem038().solve();
    }

    @Override
    public void solve() {
        int record = 0;

        for (int n=1; n<100000; n++) {
            String s = "";
            for (int i=1; i<10000; i++) {
                s += Integer.toString(n * i);

                if (s.length()>=9)
                    break;
            }

            if (s.length() == 9) {
                int res = Integer.parseInt(s);
                if (isPandigital(res)) {
                    if (res > record)
                        record = res;
                }
            }
        }

        System.out.println("Record: " + record);
    }

    boolean isPandigital(int n) {
        HashSet<Integer> set = new HashSet<>();

        // Add as unique items into the set
        while (n > 0) {
            int i = n % 10;
            if (set.contains(i))
                return false;

            set.add(i);
            n/=10;
        }

        // Query
        int q = 1;
        for (Integer i: set) {
            if (i != q)
                return false;

            q++;
        }

        return true;
    }
}
