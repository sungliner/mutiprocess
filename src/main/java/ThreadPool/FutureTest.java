package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<>(()->{
            TimeUnit.MICROSECONDS.sleep(500);
            return 2000;
        });
        new Thread(task).start();
        System.out.println(task.get());//阻塞

        ExecutorService service= Executors.newFixedThreadPool(6);
        Future<Integer> f=service.submit(()->{
                TimeUnit.MICROSECONDS.sleep(500);
                return 1;
        });
        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }

}
