package singleton;

public class Singleton1 {
    private static Singleton1 instance=new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 singleton1=new Singleton1();
        Singleton1 singleton11=new Singleton1();
    }
}
