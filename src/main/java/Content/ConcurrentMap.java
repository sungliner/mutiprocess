package Content;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConcurrentMap {
    public static void main(String[] args) {
        Map<String,String> map=new ConcurrentSkipListMap<>();//HashMap<>();

        Random r=new Random();
        Thread[] ths=new Thread[100];
        CountDownLatch latch=new CountDownLatch(ths.length);
        long start=System.currentTimeMillis();
        for (int i=0;i<ths.length;i++){
            ths[i]=new Thread(()->{
                for (int j=0;j<1000;j++){
                    map.put("a"+r.nextInt(10000),"a"+r.nextInt(100000));
                }
                latch.countDown();
            });
        }
        Arrays.asList(ths).forEach(t->t.start());
        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
