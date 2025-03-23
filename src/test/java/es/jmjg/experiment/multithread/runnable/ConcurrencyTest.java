package es.jmjg.experiment.multithread.runnable;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ConcurrencyTest extends CaptureConsoleOutputTest {

    @Test
    void test() {
        int delay = 300;
        List<String> expectedOutput = Arrays.asList(
            "Loop [12], Iteration: 1",
            "Loop [12], Iteration: 1",
            "Loop [12], Iteration: 2",
            "Loop [12], Iteration: 2",
            "Loop [12], Iteration: 3",
            "Loop [12], Iteration: 3",
            "Loop [12], Iteration: 4",
            "Loop [12], Iteration: 4",
            "Loop [12], Iteration: 5",
            "Loop [12], Iteration: 5"
            );

        Thread thread1 = new Thread(new Concurrency(1, delay));
        Thread thread2 = new Thread(new Concurrency(2, delay));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertOutputMatches(expectedOutput);
    }
}

