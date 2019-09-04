import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger i=new AtomicInteger();
        i.set(1000);
        Main m=new Main();
        m.fun(i);
        System.out.println(i);
    }

    public void fun(AtomicInteger i){
        i.set(1000);
    }
}
