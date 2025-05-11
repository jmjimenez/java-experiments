package es.jmjg.experiment.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserDefinedFunctionExperimentTest {
    private UserDefinedFunctionExperiment experiment = new UserDefinedFunctionExperiment();

    @Test
    void add_ShouldAddThreeNumbers() {
        assertEquals(0, experiment.add.apply(0, 0, 0), "Adding 0, 0 and 0 should return 0");
        assertEquals(6, experiment.add.apply(1, 2, 3), "Adding 1, 2 and 3 should return 6");
        assertEquals(-4, experiment.add.apply(-1, -2, -1), "Adding -1, -2 and -1 should return -4");
        assertEquals(100, experiment.add.apply(30, 40, 30), "Adding 30, 40 and 30 should return 100");
    }

    @Test
    void getRandomNumber_ShouldReturnNumberBetween0And99() {
        Integer range = 100;
        for (int i = 0; i < 100; i++) {
            Integer result = experiment.getRandomNumber(range).apply();
            assertTrue(result >= 0 && result < range, "Random number should be between 0 and 99, but was: " + result);
        }
    }

    @Test
    void getRandomNumber_ShouldReturnNumberBetween0And10() {
        int range = 10;
        experiment = new UserDefinedFunctionExperiment(range);
        for (int i = 0; i < 100; i++) {
            Integer result = experiment.getRandomNumber.apply();
            assertTrue(result >= 0 && result < range, "Random number should be between 0 and 10, but was: " + result);
        }
    }

    @Test
    void getRandomNumber_ShouldReturnNumberBetween0And100() {
        int range = 100;
        experiment = new UserDefinedFunctionExperiment(range);
        for (int i = 0; i < 100; i++) {
            Integer result = experiment.getRandomNumber.apply();
            assertTrue(result >= 0 && result < range, "Random number should be between 0 and 100, but was: " + result);
        }
    }
} 