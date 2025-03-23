package es.jmjg.experiment.multithread.executorservice;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import es.jmjg.experiment.shared.FakeCaptureConsoleOutputTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ExecutorServiceTest  extends FakeCaptureConsoleOutputTest {
    @Test
    void testRunnable() {
        ExecutorService executorService = new ExecutorService();
        String expectedOutput = "runnableTask";

        executorService.executeRunnable();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testCallable() {
        ExecutorService executorService = new ExecutorService();
        List<String> expectedOutput = Arrays.asList(
            "Task's execution",
            "Task's execution",
            "Task's execution"
        );

        executorService.executeCallable();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testExecuteAndShutdown() {
        ExecutorService executorService = new ExecutorService();
        List<String> expectedOutput = Arrays.asList(
            "Executor starts",
            "runnableTask starts",
            "Executor ends",
            "runnableTask interrupted"
        );

        executorService.executeAndShutdown();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testExecuteAndAwait() throws InterruptedException {
        ExecutorService executorService = new ExecutorService();
        List<String> expectedOutput = Arrays.asList(
            "Executor starts",
            "runnableTask starts",
            "runnableTask ends",
            "Executor ends"
        );

        Assertions.assertFalse(executorService.executeAndAwait());

        assertOutputIs(expectedOutput);
    }
}

