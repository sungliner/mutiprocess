package CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class TEST {
    public static void main(String[] args) {
        AtomicInteger data=new AtomicInteger(5);
        System.out.println(data.compareAndSet(5, 2019));
        data.getAndIncrement();
    }
}
