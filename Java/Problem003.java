public class Problem003 implements Problem {

    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143 ?

    public static void main(String[] args) {
        new Problem003().solve();
    }

    @Override
    public void solve() {
        long n = 600851475143L;
        int i = 2;

        while (n != 1) {
            while (i <= n) {
                if (n % i == 0) {
                    n /= i;
                    if (n == 1)
                        System.out.println("Largest prime: " + i);
                } else {
                    break;
                }
            }
            i++;
        }
    }
}
