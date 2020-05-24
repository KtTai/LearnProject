package kttai.learnThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread20200524 {

    public static void main(String[] args) {
        T1_24 t1_24 = new T1_24();
//        t1_24.run();
        System.out.println("state 1 +++++++"+t1_24.getState());

        t1_24.start();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService

        try {
            System.out.println("sleep start");
            System.out.println("state 1 +++++++"+t1_24.getState());
            t1_24.join();
            System.out.println("state 1 +++++++"+t1_24.getState());

            TimeUnit.SECONDS.sleep(10);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T1_24 extends Thread{
    @Override
    public void run() {
        System.out.println("t124 run");
        System.out.println("sleep in start");
        try {
            TimeUnit.SECONDS.sleep(10);
            Thread.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep in end");
    }
}
