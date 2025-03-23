package es.jmjg.experiment.multithread.schedule;

import es.jmjg.experiment.shared.FakeCaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExecuteScheduledThreadPoolTest extends FakeCaptureConsoleOutputTest {
    @Test
    public void test() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Repeated task should be pending",
            "Repeated task performed",
            "Repeated task performed",
            "Repeated task performed",
            "Repeated task should be finished"
        );

        ExecuteScheduledThreadPool executeScheduledThreadPool = new ExecuteScheduledThreadPool();

        executeScheduledThreadPool.execute();

        assertOutputIs(expectedOutput);
    }
}
