package es.jmjg.experiment.multithread.blockingqueue;

import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class BlockingQueueExperimentTest extends CaptureConsoleOutputTest {

    @Test
    void testNumberProducer() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(9);
        NumberProducer producer = new NumberProducer(queue, 8);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        producerThread.join();

        assertEquals(9, queue.size());
        for (int i = -2; i < 10; i++) {
            assertEquals(8 + i, queue.take());
        }
        assertEquals(NumberProducer.POISON_PILL, queue.take());
    }

    @Test
    void testNumberProducerWithSeed() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(9);
        NumberProducer producer = new NumberProducer(queue, 3);
        Thread producerThread = new Thread(producer);

        producerThread.start();
        producerThread.join();

        assertEquals(9, queue.size());
        for (int i = -2; i < 10; i++) {
            assertEquals(3 + i, queue.take());
        }
        assertEquals(NumberProducer.POISON_PILL, queue.take());
    }

    @Test
    void testNumberConsumer() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(9);
        NumberConsumer consumer = new NumberConsumer(queue);
        Thread consumerThread = new Thread(consumer);

        for (int i = -2; i < 10; i++) {
            queue.put(i);
        }
        queue.put(NumberProducer.POISON_PILL);

        consumerThread.start();
        consumerThread.join();

        assertTrue(queue.isEmpty());
    }

    @Test
    void testBlockingQueueExperiment() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
                "Produced: 0",
                "Consumed: 0",
                "Produced: 1",
                "Consumed: 1",
                "Produced: 2",
                "Consumed: 2",
                "Produced: 3",
                "Consumed: 3",
                "Produced: 4",
                "Consumed: 4",
                "Produced: 5",
                "Consumed: 5",
                "Produced: 6",
                "Consumed: 6",
                "Produced: 7",
                "Consumed: 7",
                "Produced: 8",
                "Consumed: 8",
                "Produced: 9",
                "Consumed: 9",
                "Producer finished",
                "Consumer finished"
        );

        BlockingQueueExperiment experiment = new BlockingQueueExperiment();
        experiment.execute();

        assertOutputMatches(expectedOutput);
    }
}
