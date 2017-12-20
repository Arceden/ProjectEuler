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

}
