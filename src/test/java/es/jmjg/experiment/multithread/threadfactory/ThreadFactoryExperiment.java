package es.jmjg.experiment.multithread.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryExperiment {
    private final MyThreadFactory threadFactory;

    public ThreadFactoryExperiment(String threadName) {
        threadFactory = new MyThreadFactory(threadName);
    }

    public void run() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = threadFactory.newThread(runnable);
            thread.start();
        }

        TimeUnit.MILLISECONDS.sleep(500);
    }
}

class MyThreadFactory implements ThreadFactory {
    private int threadId;
    private String name;

    public MyThreadFactory(String name) {
        threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "_" + threadId);
        threadId++;
        return t;
    }    
}