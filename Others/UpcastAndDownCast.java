package Concepts.Others;

class Parent {
    protected String name;
    public void display()
    {
        System.out.println("This is parent class");
    }
}
class Child extends Parent {
    protected int age;
    public void display()
    {
        System.out.println("This is a Child class");
    }
}
public class UpcastAndDownCast {
    public static void main(String[] args) {
        Parent a = new Parent();
        a.display();
        if(a instanceof Parent)
        {
            System.out.println("obj a is an instance of  Parent");
        }
        Parent b = (Parent) new Child();
        b.display();
        Child c = new Child();
        c.name = "Aathi";
        c.age = 20;
        System.out.println(c.name +" is "+ c.age + " years old");

    }
}
