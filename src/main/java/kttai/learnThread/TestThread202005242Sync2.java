package kttai.learnThread;

import java.util.concurrent.TimeUnit;

public class TestThread202005242Sync2 {

    private static void tFun(Object o){
        System.out.println(Thread.currentThread().getName() + ".........start");
        synchronized(o){
            System.out.println(Thread.currentThread().getName() + "......... monitor enter");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
            tFun2(o);
            System.out.println(Thread.currentThread().getName() + "......... monitor exit");
        }
        System.out.println(Thread.currentThread().getName() + ".........end");
    }

    private static void tFun2(Object o){
        System.out.println(Thread.currentThread().getName() + "....2.....start");
        synchronized(o){
            System.out.println(Thread.currentThread().getName() + "......2... monitor enter");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
            System.out.println(Thread.currentThread().getName() + ".....2.... monitor exit");
        }
        System.out.println(Thread.currentThread().getName() + ".....2....end");
    }
    private static /*volatile*/ int count = 0;
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            tFun(o);
        },"thread1");
        Thread t2 = new Thread(() -> {
            tFun(o);
        },"thread2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end:::::"+count);
    }

}


