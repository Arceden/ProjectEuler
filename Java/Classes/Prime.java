package Classes;

public class Prime {

    public static boolean isCircular(int n) {
        int q = n;

        do {
            if (!isPrime(n))
                return false;
        } while (((n = shiftNumber(n)) != q));

        return true;
    }

    private static int shiftNumber(int n) {
        int shift = n % 10;
        int i = n;
        n /= 10;

        while (i > 10) {
            shift *= 10;
            i /= 10;
        }

        n += shift;

        return n;
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }
}
