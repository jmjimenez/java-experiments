package es.jmjg.experiment.multithread.schedule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

class SingleThreadSchedulerTest {

    private final SingleThreadScheduler scheduler = new SingleThreadScheduler();

    @Test
    void executeInTime() throws ExecutionException, InterruptedException, TimeoutException {
        String test = "Patata";
        Assertions.assertEquals(test, scheduler.executeInTime(test));
    }

    @Test
    void executeOutOfTime() throws ExecutionException, InterruptedException, TimeoutException {
        String test = "Patata";
        Assertions.assertNull(scheduler.executeOutOfTime(test));
    }
}