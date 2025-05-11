package es.jmjg.experiment.multithread.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExperiment {
    public void execute() throws InterruptedException {
        BlockingQueue<Integer> queue = new java.util.concurrent.ArrayBlockingQueue<>(10);
        Thread producerThread = new Thread(new NumberProducer(queue, 0));
        Thread consumerThread = new Thread(new NumberConsumer(queue));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

class NumberProducer implements Runnable {
    static final int POISON_PILL = -1;

    private final int seed;
    private final BlockingQueue<Integer> queue;

    public NumberProducer(BlockingQueue<Integer> queue, int seed) {
        this.queue = queue;
        this.seed = seed;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Produced: " + i);
                queue.put(seed + i);
            }
            queue.put(POISON_PILL);
            System.out.println("Producer finished");
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class NumberConsumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public NumberConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take();
                if (number == NumberProducer.POISON_PILL) {
                    break;
                }
                System.out.println("Consumed: " + number);
            }
            System.out.println("Consumer finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
