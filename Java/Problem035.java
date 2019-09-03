import Classes.Prime;

public class Problem035 implements Problem {
    public static void main(String[] args) {
        new Problem035().solve();
    }

    @Override
    public void solve() {
        int limit = 1000000;
        int sum = 1;

        for (int i=3; i<limit; i += 2)
            if (Prime.isCircular(i))
                sum++;

        System.out.println(sum);
    }
}
