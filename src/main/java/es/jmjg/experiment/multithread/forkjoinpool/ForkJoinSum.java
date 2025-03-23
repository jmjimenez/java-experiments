package es.jmjg.experiment.multithread.forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Long> {
    private final long[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 1_000;

    public ForkJoinSum(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            System.out.println("start: " + start + " end: " + end);
            int mid = start + length / 2;
            ForkJoinSum leftTask = new ForkJoinSum(array, start, mid);
            ForkJoinSum rightTask = new ForkJoinSum(array, mid, end);
            leftTask.fork(); // asynchronously execute the left task
            long rightResult = rightTask.compute(); // compute the right task
            long leftResult = leftTask.join(); // wait for the left task to complete
            return leftResult + rightResult;
        }
    }
}