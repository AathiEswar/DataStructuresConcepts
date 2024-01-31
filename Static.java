package Concepts;

class GetNSet{
    private String name;
    static
    {
        System.out.println("This is a test for get and set");
    }
    public String get()
    {
        return name;
    }
    public void set(String name)
    {
        this.name = name;
    }
}
public class Static {
    public static void main(String[] args) {
        GetNSet n = new GetNSet();
        n.set("Aathi");
        System.out.println(n.get());
    }
}
