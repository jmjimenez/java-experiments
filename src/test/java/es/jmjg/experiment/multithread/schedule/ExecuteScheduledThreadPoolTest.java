package es.jmjg.experiment.multithread.schedule;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExecuteScheduledThreadPoolTest extends CaptureConsoleOutputTest {
    @Test
    public void test() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Scheduled task should be pending",
            "Scheduled task executed after 1 second",
            "ScheduledExecutorService shut down",
            "Scheduled task should be finished"
        );

        ExecuteScheduledThreadPool executeScheduledThreadPool = new ExecuteScheduledThreadPool();

        executeScheduledThreadPool.execute();

        assertOutputMatches(expectedOutput);
    }
}
