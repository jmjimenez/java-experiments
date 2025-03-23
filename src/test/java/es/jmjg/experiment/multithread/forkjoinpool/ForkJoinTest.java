package es.jmjg.experiment.multithread.forkjoinpool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("resource")
public class ForkJoinTest {

    private int[] arr;
    private CustomRecursiveTask customRecursiveTask;

    @BeforeEach
    public void init() {
        Random random = new Random();
        arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(35);
        }
        customRecursiveTask = new CustomRecursiveTask(arr);
    }

    @Test
    public void testPoolUtil() {
        ForkJoinPool forkJoinPool = PoolUtil.forkJoinPool;
        ForkJoinPool forkJoinPoolTwo = PoolUtil.forkJoinPool;

        assertNotNull(forkJoinPool);
        assertEquals(2, forkJoinPool.getParallelism());
        assertEquals(forkJoinPool, forkJoinPoolTwo);
    }

    @Test
    public void testCommonPool() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        ForkJoinPool commonPoolTwo = ForkJoinPool.commonPool();

        assertNotNull(commonPool);
        assertEquals(commonPool, commonPoolTwo);
    }

    @Test
    public void testInvoke() {
        CustomRecursiveAction myRecursiveAction = new CustomRecursiveAction("ddddffffgggghhhh");
        ForkJoinPool.commonPool().invoke(myRecursiveAction);

        assertTrue(myRecursiveAction.isDone());
    }

    @Test
    public void testExecuteAndJoin() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.execute(customRecursiveTask);
        customRecursiveTask.join();
        assertTrue(customRecursiveTask.isDone());

        forkJoinPool.submit(customRecursiveTask);
        customRecursiveTask.join();
        assertTrue(customRecursiveTask.isDone());
    }
}