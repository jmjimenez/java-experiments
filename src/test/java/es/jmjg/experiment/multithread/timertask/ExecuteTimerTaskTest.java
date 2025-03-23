package es.jmjg.experiment.multithread.timertask;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExecuteTimerTaskTest extends CaptureConsoleOutputTest {
    @Test
    public void test() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Schedule should be pending",
            "Scheduled task performed",
            "Schedule should be finished"
        );

        ExecuteTimerTask executeTimerTask = new ExecuteTimerTask();

        executeTimerTask.execute();

        assertOutputIs(expectedOutput);
    }
}
