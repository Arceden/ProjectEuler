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

}
