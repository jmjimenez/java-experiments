package es.jmjg.experiment.multithread.forkjoinpool;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class TransmitableThreadLocal {
    public final List<String> result = Collections.synchronizedList(new ArrayList<>());

    public void test(String firstTransactionIdValue, String secondTransactionIdValue) {
        TransmittableThreadLocal<String> transactionID = new TransmittableThreadLocal<>();
        transactionID.set(firstTransactionIdValue);

        try {
            ExecutorService exe1 = TtlExecutors.getTtlExecutorService(new ForkJoinPool(4));
            ExecutorService exe2 = TtlExecutors.getTtlExecutorService(new ForkJoinPool(4));

            exe1.submit(
                () -> List.of(1, 2, 3, 4, 5)
                    .parallelStream()
                    .forEach(i -> {
                        waitRandom();
                        System.out.println("transactionidvalue " + firstTransactionIdValue + " get " + transactionID.get());
                        result.add(transactionID.get());
                    })
            );

            transactionID.set(secondTransactionIdValue);

            exe2.submit(
                    () -> List.of(1, 2, 3, 4, 5)
                        .parallelStream()
                        .forEach(i -> {
                            waitRandom();
                            System.out.println("transactionidvalue " + secondTransactionIdValue + " get " + transactionID.get());
                            result.add(transactionID.get());
                        })
                );

            //noinspection ResultOfMethodCallIgnored
            exe1.awaitTermination(10, TimeUnit.SECONDS);

            //noinspection ResultOfMethodCallIgnored
            exe2.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void waitRandom() {
        int randomNumber = getRandom();
        try {
            Thread.sleep(randomNumber);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized int getRandom() {
        Random random = new Random();
        int min = 1000;
        int max = 10000;
        return random.nextInt(max - min) + min;
    }
}
