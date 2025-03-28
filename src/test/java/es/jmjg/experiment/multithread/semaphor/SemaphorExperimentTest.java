package es.jmjg.experiment.multithread.semaphor;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SemaphorExperimentTest extends CaptureConsoleOutputTest {
    SemaphorExperiment semaphorExperiment = new SemaphorExperiment();

    @Test
    public void test() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Before submitting tasks",
            "Task starts",
            "Task starts",
            "Task starts",
            "Task starts",
            "Task starts",
            "Task starts",
            "Task ends",
            "Task ends",
            "Task ends",
            "After submitting tasks",
            "Task ends",
            "Task ends",
            "Task ends"
        );

        semaphorExperiment.execute();

        assertOutputMatches(expectedOutput);
    }
}