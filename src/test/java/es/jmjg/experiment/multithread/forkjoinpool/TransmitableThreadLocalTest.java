package es.jmjg.experiment.multithread.forkjoinpool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TransmitableThreadLocalTest {
    private final TransmitableThreadLocal test = new TransmitableThreadLocal();

    @Test
    void test() {

        String firstTransactionIDValue = UUID.randomUUID().toString();
        String secondTransactionIDValue = UUID.randomUUID().toString();

        test.test(firstTransactionIDValue, secondTransactionIDValue);

        Assertions.assertEquals(10, test.result.size());
        Assertions.assertEquals(5, test.result.stream().filter(r -> r.equals(firstTransactionIDValue)).toList().size());
        Assertions.assertEquals(5, test.result.stream().filter(r -> r.equals(secondTransactionIDValue)).toList().size());
    }
}
