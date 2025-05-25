package es.jmjg.experiment.functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.BiFunction;

class PartialsExperimentTest {
    
    @Test
    void addPartial_ShouldAddTwoNumbers() {
        BiFunction<Integer, Integer, Integer> add = PartialsExperiment.addPartial.apply(1);

        assertEquals(6, add.apply(2, 3), "Adding 1, 2 and 3 should return 6");
        assertEquals(8, add.apply(3, 4), "Adding 1, 3 and 4 should return 8");
        assertEquals(10, add.apply(4, 5), "Adding 1, 4 and 5 should return 10");
    }
    
} 