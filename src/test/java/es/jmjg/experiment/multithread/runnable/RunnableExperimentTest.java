package es.jmjg.experiment.multithread.runnable;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

class RunnableExperimentTest extends CaptureConsoleOutputTest {

    @Test
    void test() {
        String expectedOutput = "Runnable executed";

        Thread thread = RunnableExperiment.getRunnableThread();

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        assertOutputIs(expectedOutput);
    }
}

