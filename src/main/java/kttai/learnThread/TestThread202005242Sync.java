package kttai.learnThread;

import java.util.concurrent.TimeUnit;

public class TestThread202005242Sync {

    private void tFun(Object o){
        synchronized(o){
            count ++;
        }
    }
    private static /*volatile*/ int count = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i =0;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (i < 50 ) {
                i ++;
                count++;
                System.out.println("t1+"+count);
            }
        });
        Thread t2 = new Thread(() -> {
            int i =0 ;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (i < 50) {
                i ++;

                count++;
                System.out.println("t2+"+count);
            }
        });

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

    private void setCountNum(){
        count++;
    }
}

class T1_242 extends Thread{
    private static /*volatile*/ int count = 0;

    @Override
    public void run() {
        int i =0;
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while (i < 50 ) {
            i ++;
            count++;
            System.out.println("t1+"+count);
        }
    }
}
