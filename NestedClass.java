package Concepts;

class Class1{
    public abstract class Class11{
        Class11(){
            System.out.println("From Class11");
        }
        public abstract void display();
    }
    public static class Class12{
        Class12(){
            System.out.println("From Class12");
        }
    }
}
public class NestedClass {
    public static void main(String[] args) {
        Class1 a = new Class1();
        Class1.Class11 aa = a.new Class11()
        {
            public void display(){
            System.out.println("Hello from main");
        }};
        aa.display();
        Class1.Class12 bb = new Class1.Class12();



    }
}
