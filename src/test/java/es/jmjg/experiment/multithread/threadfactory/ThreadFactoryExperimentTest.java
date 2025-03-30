package es.jmjg.experiment.multithread.threadfactory;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;

class ThreadFactoryExperimentTest extends CaptureConsoleOutputTest {

    @Test
    void testRun() throws InterruptedException {
        String threadName = "TestThread";

        List<String> expectedOutput = Arrays.asList(
            threadName + "_[1-5] is running",
            threadName + "_[1-5] is running",
            threadName + "_[1-5] is running",
            threadName + "_[1-5] is running",
            threadName + "_[1-5] is running"
        );

        ThreadFactoryExperiment experiment = new ThreadFactoryExperiment(threadName);

        experiment.run();

        assertOutputMatches(expectedOutput);
    }
}
