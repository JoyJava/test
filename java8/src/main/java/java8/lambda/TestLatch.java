package java8.lambda;

import java.util.concurrent.CountDownLatch;

public class TestLatch {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        CountDownLatch startGate = new CountDownLatch(3);
        CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {

            final int finalI = i;
            Runnable t = () -> {
                try {
                    System.out.println(" 等启动命令... TID:" + Thread.currentThread().getId());
                    startGate.await();
                    System.out.println(" 接收到启动命令... TID:" + Thread.currentThread().getId());

                    try {
                        System.out.println("启动子任务:" + Thread.currentThread().getId());
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            };
            new Thread(t).start();
        }
        long start = System.nanoTime();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startGate.countDown();
        startGate.countDown();
        startGate.countDown();

        endGate.await();
        System.out.println(System.nanoTime() - start);
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        Runnable t = () -> {
            System.out.println("-----------线程ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        try {
            new TestLatch().timeTasks(10, t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}