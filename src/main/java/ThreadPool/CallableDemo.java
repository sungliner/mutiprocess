package ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo<Interger> implements Callable {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> f=new FutureTask<Integer>((Callable<Integer>) new CallableDemo());
        new Thread(f).start();
        System.out.println(f.get());
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread()+"开始");
        return 1;
    }
}
