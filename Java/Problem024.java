/*
    A permutation is an ordered arrangement of objects.
    For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
    If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
    The lexicographic permutations of 0, 1 and 2 are:
        012   021   102   120   201   210
    What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

import java.util.ArrayList;

public class Problem024 implements Problem {
    int index = 0;

    public static void main(String[] args) {
        new Problem024().solve();
    }

    @Override
    public void solve() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<=9; i++)
            numbers.add(i);
        lexico(numbers, "Sequence: ");
    }

    /** This should be recursive in which the base case prints the sequence */
    private void lexico(ArrayList<Integer> numbers, String seq) {
        // Base case
        if (numbers.size() == 1) {
            index++;
            if(index == 1000000)
                System.out.println(seq + numbers.get(0));
            return;
        }

        for (int i=0; i<numbers.size(); i++) {
            // Copy list and remove the current number
            ArrayList<Integer> next = new ArrayList<>(numbers);
            next.remove(i);
            lexico(next, seq + numbers.get(i));
        }
    }
}
