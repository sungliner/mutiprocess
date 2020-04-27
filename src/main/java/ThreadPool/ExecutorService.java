package ThreadPool;

import java.util.concurrent.Executor;

public class ExecutorService implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new ExecutorService().execute(()->{
            System.out.println("hello executer");
        });
    }
}
