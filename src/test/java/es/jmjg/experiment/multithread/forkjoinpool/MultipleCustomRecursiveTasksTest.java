package es.jmjg.experiment.multithread.forkjoinpool;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MultipleCustomRecursiveTasksTest extends CaptureConsoleOutputTest {

    @Test
    public void testCompute() {
        List<String> expectedOutput = Arrays.asList(
            "Fist task is done:true",
            "Second task is done:true",
            "Third task is done:true",
            "Result is 360"
        );
        MultipleCustomRecursiveTasks multipleCustomRecursiveTasks = new MultipleCustomRecursiveTasks();

        multipleCustomRecursiveTasks.compute();

        assertOutputIs(expectedOutput);
    }
}