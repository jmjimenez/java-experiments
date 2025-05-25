package es.jmjg.experiment.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class ReduceExperimentTest {
    ReduceExperiment experiment = new ReduceExperiment();

    @Test
    public void testSumAll() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Integer expected = 10;

        Assertions.assertEquals(
            expected,
            experiment.sumAll(list)
        );
    }
}
