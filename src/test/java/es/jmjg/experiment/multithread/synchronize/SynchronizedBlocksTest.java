package es.jmjg.experiment.multithread.synchronize;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SynchronizedBlocksTest {
    @Test
    void testRun() {
        int expected = 1000;

        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedBlocks synchronizedBlocks = new SynchronizedBlocks();
        IntStream
            .range(0, 1000)
            .forEach(count -> service.submit(synchronizedBlocks::performSynchronisedTask));
        try {
            //noinspection ResultOfMethodCallIgnored
            service.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(synchronizedBlocks.getCount());
        service.shutdownNow();

        assertEquals(expected, synchronizedBlocks.getCount());
    }
}

