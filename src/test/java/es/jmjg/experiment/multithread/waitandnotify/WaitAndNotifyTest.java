package es.jmjg.experiment.multithread.waitandnotify;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WaitAndNotifyTest extends CaptureConsoleOutputTest {

    @Test
    public void test() throws InterruptedException {
        List<String> expected = Arrays.asList(
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet"
        );
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();

        sender.join();
        receiver.join();

        assertOutputIs(expected);
    }
}
