package Concepts;
class PolyPar{
    protected void display()
    {
        System.out.println("This is the parent");
    }
}
class PolyChi {

    public  void display()
    {

        System.out.println("This is the child");
    }

}
public class Polymorphism {
    public static void main(String[] args) {
        PolyChi a = new PolyChi();
        a.display();
    }
}
