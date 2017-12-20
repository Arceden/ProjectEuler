package Problems;

public class Functions {

    //Make a prefix
    private String prefix = getClass().getSimpleName()+" answer: ";

    public void print(String msg){
        System.out.println(prefix+msg);
    }

    public void print(int msg){
        System.out.println(prefix+msg);
    }

    public void print(long msg) { System.out.println(prefix+msg); }

    public void print(double msg) { System.out.println(prefix+msg); }

    public void print(float msg) { System.out.println(prefix+msg); }

    public boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

}
