package ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    Lock lock=new ReentrantLock();
    void m1(){
        try{
            lock.lock();
            for(int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2(){
        /*
        lock.lock();*/
        Boolean locked=lock.tryLock();
        System.out.println("m2......");
        if (locked){
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest r1=new ReentrantLockTest();
        new Thread(r1::m1).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
