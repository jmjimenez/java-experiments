package es.jmjg.experiment.unittest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumDynamicTest {
    private record Scenario(String description, int a, int b, int sum) {}

    private final Calculator calculator = new Calculator();

    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {
        List<Scenario> scenarios = new ArrayList<>(Arrays.asList(
            new Scenario("Test 1", 1, 2, 3),
            new Scenario("Test 2", 2, 2, 4),
            new Scenario("Test 3", 3, 3, 6)
        ));

        return scenarios.stream()
            .map(scenario -> DynamicTest.dynamicTest(
                scenario.description,
                () -> assertEquals(scenario.sum, calculator.sum(scenario.a, scenario.b))
            ));
    }
}
