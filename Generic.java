package Concepts;

import java.util.Arrays;
import java.util.Collections;

class Aa{
    public <T> void display(T... t){
        for(T i : t){
            System.out.println(i);
        }

    }

    public void show(Object... t){
        System.out.println(Arrays.toString(t));
    }

    public void max(Integer... t){
        System.out.println(Collections.max(Arrays.asList(t)));
    }
}
public class Generic {
    public static void main(String[] args) {
        Aa a = new Aa();
        a.display(1,"hehe");
        a.display("aathi");
        a.display(1.234);

        a.show(1,"wow",1.222222,'d');
        a.show("aathi");
        a.show(1.234);

        a.max(1,2,3,4,5,6,3,6,4523,42,4,24);
    }
}
