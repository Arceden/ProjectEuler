import Classes.Prime;

public class Problem035 implements Problem {
    public static void main(String[] args) {
        new Problem035().solve();
    }

    @Override
    public void solve() {
        int limit = 1000000;
        int sum = 0;

        for (int i=2; i<limit; i++)
            if (Prime.isCircular(i))
                sum++;

        System.out.println(sum);
    }
}
