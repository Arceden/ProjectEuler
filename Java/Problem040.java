public class Problem040 implements Problem {
    public static void main(String[] args) {
        new Problem040().solve();
    }

    @Override
    public void solve() {
        Champernowne cham = new Champernowne();
        int sum = cham.getDigit(1);

        for (int i=10; i <= 1000000; i*=10)
            sum *= cham.getDigit(i);

        System.out.println(sum);
    }

    /**
     * Code can be optimized by remembering the digit count of 10, 100, 1000 etc
     */
    private class Champernowne {
        private int tail = 0;
        String sequence;

        public Champernowne() {
            sequence = "";
        }

        public int getDigit(int n) {
            if (n == 0)
                return 0;

            while (n > sequence.length()) {
                sequence += ++tail;
            }

            return Integer.parseInt(sequence.substring(n-1, n));
        }
    }
}
