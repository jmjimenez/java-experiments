package es.jmjg.experiment.multithread.thread;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

public class NewThreadTest extends CaptureConsoleOutputTest {
    @Test
    public void test() throws InterruptedException {
        String expectedOutput = "Hello from inside an anonymous Thread";

        new Thread(() -> System.out.println(expectedOutput)).start();
        Thread.sleep(500);

        assertOutputIs(expectedOutput);
    }
}
