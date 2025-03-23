package es.jmjg.experiment.multithread.forkjoinpool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

class ForkJoinSumTest {

    @Test
    void test() {
        long[] array = new long[20_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long result;
        try (ForkJoinPool pool = new ForkJoinPool()) {
            ForkJoinSum task = new ForkJoinSum(array, 0, array.length);
            result = pool.invoke(task);
        }

        System.out.println("Calculator: " + result);

        Assertions.assertEquals(199_990_000, result);
    }
}

