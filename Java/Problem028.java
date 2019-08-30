import java.util.LinkedList;

public class Problem028 implements Problem {
    public static void main(String[] args) {
        new Problem028().solve();
    }

    @Override
    public void solve() {
        getSpiral(1001);
    }

    /**
     * @param size > 2
     */
    void getSpiral(int size) {
        size /= 2;
        size++;
        int last = 0;
        int sum = 0;

        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Integer> diagonals = new LinkedList<>();

        // Get amount of spirals to make
        for (int i=0; i<size; i++) {
            int row = getAmountForSpiral(i);


            // Get numbers to push into the spiral row
            for (int x=0; x<row; x++) {
                numbers.add(++last);

                if (row == 1 || (x-((row/2)-1)) % (row/4) == 0) {
                    diagonals.add(last);
                    sum += last;
                }
            }
        }

        System.out.println("Diagonals: \t" + diagonals);
        System.out.println("Sum: \t\t" + sum);
    }

    int getAmountForSpiral(int n) {
        if (n == 0)
            return 1;

        return n * 8;
    }
}
