package kttai.learnThread;

public class TestThread20200522 {
    public static void main(String[] args) {

        new T1().start();
        new T2().start();
        new T3().start();
        new Thread(() -> {
            System.out.println("run thread T Lambda");
        },"nameLambda").start();

        T4 t4 = new T4();
        new Thread(t4).start();
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        System.out.println("run thread T1 start");
        try {
            this.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run thread T1 end");
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        System.out.println("run thread T2");
    }
}

class T3 extends Thread{
    @Override
    public void run() {
        System.out.println("run thread T3");
    }
}

class T4 implements Runnable{
    @Override
    public void run() {
        System.out.println("run runnable T4");
    }
}

