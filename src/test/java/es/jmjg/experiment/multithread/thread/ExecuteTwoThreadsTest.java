package es.jmjg.experiment.multithread.thread;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExecuteTwoThreadsTest extends CaptureConsoleOutputTest {

    @Test
    void testTwoConcurrency() {
        int milliseconds = 500;

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

        final ExecuteTwoThreads executeTwoThreads = new ExecuteTwoThreads();

        executeTwoThreads.execute(milliseconds);

        assertOutputMatches(expectedOutput);
    }
}
