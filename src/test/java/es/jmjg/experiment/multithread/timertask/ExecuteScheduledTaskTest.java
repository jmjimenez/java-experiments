package es.jmjg.experiment.multithread.timertask;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExecuteScheduledTaskTest extends CaptureConsoleOutputTest {
    @Test
    public void test() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Repeated task should be pending",
            "Repeated task performed",
            "Repeated task performed",
            "Repeated task performed",
            "Repeated task should be finished"
        );

        ExecuteScheduledTask executeTimerTask = new ExecuteScheduledTask();

        executeTimerTask.execute();

        assertOutputIs(expectedOutput);
    }
}
