package Concepts.SingleInstance;

public class SingleInstanceExample {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.display();
    }
}

class Singleton {
    private Singleton(){}

    public void display(){
        System.out.println("hello from single instance ");
    }

    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}