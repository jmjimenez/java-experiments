package es.jmjg.experiment.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class MapExperimentTest {
    MapExperiment experiment = new MapExperiment();

    @Test
    public void testTimesTwo() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8);

        Assertions.assertEquals(
            expected,
            experiment.timesTwo(list)
        );
    }

    @Test
    public void testGetNames() {
        List<Person> list = Arrays.asList(
            new Person("John", 20, "Developer", 100000),
            new Person("Jane", 21, "Developer", 100000),
            new Person("Jim", 22, "Developer", 100000)
        );
        List<String> expected = Arrays.asList("John", "Jane", "Jim");

        Assertions.assertEquals(
            expected,
            experiment.getNames(list)
        );
    }

}
