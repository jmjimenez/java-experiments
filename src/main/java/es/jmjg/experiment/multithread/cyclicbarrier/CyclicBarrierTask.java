package es.jmjg.experiment.multithread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public CyclicBarrierTask(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " starts waiting cyclicBarrier");
            barrier.await();
            System.out.println(name + " is released");
        } catch (InterruptedException | BrokenBarrierException ignored) {
        }
    }

}