package es.jmjg.experiment.multithread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class PoolUtil {
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(2);
}