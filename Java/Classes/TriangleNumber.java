package Classes;

public class TriangleNumber {
    private int total;
    private int last_row;

    public TriangleNumber() {
        last_row = 0;
        total = last_row;
    }

    public int next() {
        last_row++;
        total += last_row;
        return total;
    }

    public int getCurrent() {
        return total;
    }
}
