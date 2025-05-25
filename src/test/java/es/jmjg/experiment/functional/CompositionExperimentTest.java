package es.jmjg.experiment.functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositionExperimentTest {
    
    @Test
    void addOneAndMultiplyByTwo_ShouldAddOneAndMultiplyByTwo() {
        assertEquals(6, CompositionExperiment.addOneAndMultiplyByTwo.apply(2));
    }

    @Test
    void multiplyByTwoAndAddOne_ShouldMultiplyByTwoAndAddOne() {
        assertEquals(5, CompositionExperiment.multiplyByTwoAndAddOne.apply(2));
    }
} 