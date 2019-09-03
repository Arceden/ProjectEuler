public class Problem036 implements Problem {
    public static void main(String[] args) {
        new Problem036().solve();
    }

    @Override
    public void solve() {
        int limit = 1000000;
        int sum = 0;
        for (int i = 1; i < limit; i++)
            if (isDoubleBase(i))
                sum += i;

        System.out.println(sum);
    }

    private boolean isDoubleBase(int n) {
        return isPalindrome(Integer.toString(n)) && isPalindrome(toBin(n));
    }

    private boolean isPalindrome(String n) {
        if (n.length() < 2)
            return true;

        if (n.substring(0, 1).equalsIgnoreCase(n.substring(n.length()-1)))
            return isPalindrome(n.substring(1, n.length()-1));

        return false;
    }

    private String toBin(int n) {
        //find starting depth
        int depth = -1;
        while (n > pow(2, ++depth)){}

        String res = toBin(n, depth);

        if (res.substring(0,1).equalsIgnoreCase("0"))
            res = res.substring(1);

        return res;
    }

    // Recursive strategy
    private String toBin(int n, int depth) {
        if (depth == 0)
            return Integer.toString(n);

        int i = 0;
        int p = pow(2, depth);
        if (n-p >= 0) {
            i = 1;
            n -= p;
        }

        return i + toBin(n, --depth);
    }

    private int pow(int n, int power) {
        if (power == 0)
            return 1;

        int sum = n;
        for (int i=0;i<power-1;i++)
            sum *= n;
        return sum;
    }
}
