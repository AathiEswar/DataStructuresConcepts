package Concepts.Others;

class RectangleCustom{
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    RectangleCustom(){
        this.x = 0;
        this.y = 0;
        this.height = 0;
        this.width = 0;
    }

    RectangleCustom(int x,int y,int height,int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void display(){
        System.out.println(x +" "+ y  +" "+ height  +" "+width);
    }
}
public class pointers {
    public static void main(String[] args) {
        RectangleCustom a = new RectangleCustom();
        System.out.println("display a");
        a.display();
        RectangleCustom b = new RectangleCustom(1,1,4,4);
        System.out.println("Display b");
        b.display();
        System.out.println("a instance = b instance");
        //the refernce value of the b instance is saved to the a variable and the refernce
        //of the a in sent to garbage collection
        a = b;
        System.out.println("display a");
        a.display();
        System.out.println("change a.x");
        a.x = 100;
        System.out.println("display b");
        b.display();

    }


}
