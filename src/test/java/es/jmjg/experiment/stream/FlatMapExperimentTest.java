package es.jmjg.experiment.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;

public class FlatMapExperimentTest {
    FlatMapExperiment experiment = new FlatMapExperiment();

    @Test
    public void testFlattenTwoLists() {
        Assertions.assertEquals(
            Arrays.asList("a", "b", "c", "d"),
            experiment.flattenTwoLists(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
            ));
    }

    @Test
    public void testFlattenListOfLists() {
        Assertions.assertEquals(
            Arrays.asList("a", "b", "c", "d"),
            experiment.flattenListOfLists(
                Arrays.asList(
                    Arrays.asList("a", "b"),
                    Arrays.asList("c", "d")
                )
            ));
    }
}
