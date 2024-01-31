package Concepts;

class ParSF{
    final String name = "Aathi";
    public void display(){
        System.out.println("This is from Parent");
    }

}
class ChiSF extends ParSF {
    public void display(){
        System.out.println("this is from Child");
    }
}
public class StaticNFinal {
    public static void main(String[] args) {
        ChiSF a = new ChiSF();

    }
}
