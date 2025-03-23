package es.jmjg.experiment.multithread.synchronize;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ThreadMessengerTest extends CaptureConsoleOutputTest {

    @Test
    void testRun() {
        int delay = 500;
        List<String> expectedOutput = Arrays.asList(
            "Thread 1, Sending message: Hello",
            "Thread 1, Message sent: Hello",
            "Thread 2, Sending message: Bye",
            "Thread 2, Message sent: Bye"
        );

        Messenger sender = new Messenger(delay);

        ThreadMessenger thread1 = new ThreadMessenger("Hello", sender);
        thread1.setName("Thread 1");
        ThreadMessenger thread2 = new ThreadMessenger("Bye", sender);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }

        assertOutputIs(expectedOutput);
    }
}

