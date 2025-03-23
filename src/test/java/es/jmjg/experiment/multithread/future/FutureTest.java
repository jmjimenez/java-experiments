package es.jmjg.experiment.multithread.future;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FutureTest extends CaptureConsoleOutputTest {
    private final FutureGet futureGet = new FutureGet();

    @Test
    void test() {
        List<String> expectedOutput = Arrays.asList(
            "Get future",
            "Future starts",
            "Hello from Future!"
        );

        futureGet.execute();

        assertOutputIs(expectedOutput);
    }
}

