package es.jmjg.experiment.multithread.executorservice;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SingleThreadExecutorTest extends CaptureConsoleOutputTest {
    @Test
    void testExecute() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Task task 1 starts",
            "Task ends",
            "Task task 2 starts",
            "Task ends"
        );

        SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();

        singleThreadExecutor.execute();

        assertOutputIs(expectedOutput);
    }
}

