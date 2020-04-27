package Content;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketSeller1 {
        static List<String> tickets=new ArrayList<>();
        //static Vector<String> tickets=new Vector<>();
        //static Queue<String> tickets=new ConcurrentLinkedDeque<>();
        static {
            for (int i=0;i<1000;i++)
                tickets.add("票编号："+i);
        }

        public static void main(String[] args) {
       /* for (int i=0;i<100;i++){
            new Thread(()->{
                while (tickets.size()>0){
                    try{
                        TimeUnit.MICROSECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售给了"+Thread.currentThread().getName()+"----"+tickets.remove(0));
                }
            }).start();
        }*/
        for (int i=0;i<20;i++){
            new Thread(()->{
                while(true){
                synchronized (tickets) {
                    if (tickets.size() <= 0) break;
                        try {
                            TimeUnit.MICROSECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售给了" + Thread.currentThread().getName() + "----" + tickets.remove(0));

                } }}).start();
        }

        }
    }


