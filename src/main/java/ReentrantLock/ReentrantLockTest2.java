package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 extends Thread{
    private static ReentrantLock lock=new ReentrantLock(true);
    public void run(){
        for (int i=0;i<100;i++){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁"+i);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        ReentrantLockTest2 r2=new ReentrantLockTest2();
        Thread t1=new Thread(r2);
        Thread t2=new Thread(r2);
        t1.start();t2.start();
    }
}
