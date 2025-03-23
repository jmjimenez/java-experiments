package es.jmjg.experiment.multithread.fixedthreadpool;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FixedThreadPoolExecutorTest extends CaptureConsoleOutputTest {
    private final FixedThreadPoolExecutor fixedThreadPoolExecutor = new FixedThreadPoolExecutor();

    @Test
    void test() {
        int numberOfConcurrency = 3;
        List<String> expectedOutput = Arrays.asList(
            "pool-[\\d*]-thread-[\\d*]: Start task [0-2]",
            "pool-[\\d*]-thread-[\\d*]: Start task [0-2]",
            "pool-[\\d*]-thread-[\\d*]: Start task [0-2]",
            "pool-[\\d*]-thread-[\\d*]: End task [0-2]",
            "pool-[\\d*]-thread-[\\d*]: End task [0-2]",
            "pool-[\\d*]-thread-[\\d*]: End task [0-2]"
        );
        fixedThreadPoolExecutor.execute(numberOfConcurrency);

        assertOutputMatches(expectedOutput);
    }
}

