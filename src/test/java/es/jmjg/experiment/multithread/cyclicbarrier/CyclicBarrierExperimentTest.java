package es.jmjg.experiment.multithread.cyclicbarrier;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class CyclicBarrierExperimentTest extends CaptureConsoleOutputTest {
    @Test
    public void testCyclicBarrier() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "T[123] starts waiting cyclicBarrier",
            "T[123] starts waiting cyclicBarrier",
            "T[123] starts waiting cyclicBarrier",
            "All 3 tasks are completed",
            "T[123] is released",
            "T[123] is released",
            "T[123] is released"
        );

        CyclicBarrierExperiment experiment = new CyclicBarrierExperiment();

        experiment.execute();

        TimeUnit.MILLISECONDS.sleep(1000);

        assertOutputMatches(expectedOutput);
    }
}