package es.jmjg.experiment.multithread.join;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JoinExperimentTest extends CaptureConsoleOutputTest {
    private final JoinExperiment joinExperiment = new JoinExperiment();

    @Test
    public void testExecute() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Thread Created",
            "Invoking join",
            "Thread .* started",
            "Inside Thread .*, processingCount = 0",
            "Thread .* exiting",
            "Returned from join",
            "Thread is alive false"
        );

        joinExperiment.execute(1);

        this.assertOutputMatches(expectedOutput);
    }
}
