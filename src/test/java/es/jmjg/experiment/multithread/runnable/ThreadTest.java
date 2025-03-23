package es.jmjg.experiment.multithread.runnable;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ThreadTest extends CaptureConsoleOutputTest {

    @Test
    void test() {
        int delay = 300;
        List<String> expectedOutput = Arrays.asList(
            "Thread [12], Iteration: 1",
            "Thread [12], Iteration: 1",
            "Thread [12], Iteration: 2",
            "Thread [12], Iteration: 2",
            "Thread [12], Iteration: 3",
            "Thread [12], Iteration: 3",
            "Thread [12], Iteration: 4",
            "Thread [12], Iteration: 4",
            "Thread [12], Iteration: 5",
            "Thread [12], Iteration: 5"
        );

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try { Thread.sleep(delay); } catch(InterruptedException e) { throw new RuntimeException(e); }
                System.out.println("Thread 1, Iteration: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try { Thread.sleep(delay); } catch(InterruptedException e) { throw new RuntimeException(e); }
                System.out.println("Thread 2, Iteration: " + i);
            }
        });

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

