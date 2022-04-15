package kttai.learnThread;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LearnCyclicBarrier {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("集结完成，出发！！！！"));

        for (int i=0 ; i<10;i++) {
            int finalI = i+1;
            new Thread(() -> {
                try {
                    System.out.println(finalI +"--到");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

//        TimeUnit.SECONDS.sleep(5);
//        System.out.println(11 +"--到");
//        cyclicBarrier.await();
    }
}
