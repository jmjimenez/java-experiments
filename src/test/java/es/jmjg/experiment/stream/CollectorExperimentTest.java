package es.jmjg.experiment.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectorExperimentTest {
    CollectorExperiment experiment = new CollectorExperiment();

    @Test
    public void testJoinAll() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        String expected = "a, b, c, d";

        Assertions.assertEquals(
            expected,
            experiment.joinAll(list)
        );
    }


    @Test
    public void testCalculateAverageSalary() {
        List<Person> list = Arrays.asList(
            new Person("John", 20, "Developer", 150000),
            new Person("Jane", 21, "Developer", 110000),
            new Person("Jim", 22, "Manager", 200000)
        );
        Map<String, Double> expected = new HashMap<>();
        expected.put("Developer", 130000.0);
        expected.put("Manager", 200000.0);

        Assertions.assertEquals(
            expected,
            experiment.calculateAverageSalary(list)
        );
    }
}
