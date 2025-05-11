package es.jmjg.experiment.functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BiFunctionExperimentTest {
    
    @Test
    void add_ShouldAddTwoNumbers() {
        assertEquals(0, BiFunctionExperiment.add.apply(0, 0), "Adding 0 and 0 should return 0");
        assertEquals(5, BiFunctionExperiment.add.apply(2, 3), "Adding 2 and 3 should return 5");
        assertEquals(-1, BiFunctionExperiment.add.apply(-3, 2), "Adding -3 and 2 should return -1");
        assertEquals(100, BiFunctionExperiment.add.apply(60, 40), "Adding 60 and 40 should return 100");
    }

    @Test
    void multiply_ShouldMultiplyTwoNumbers() {
        assertEquals(0, BiFunctionExperiment.multiply.apply(0, 5), "Multiplying 0 and 5 should return 0");
        assertEquals(6, BiFunctionExperiment.multiply.apply(2, 3), "Multiplying 2 and 3 should return 6");
        assertEquals(-6, BiFunctionExperiment.multiply.apply(-3, 2), "Multiplying -3 and 2 should return -6");
        assertEquals(2400, BiFunctionExperiment.multiply.apply(60, 40), "Multiplying 60 and 40 should return 2400");
    }

    @Test
    void divide_ShouldDivideTwoNumbers() {
        assertEquals(2, BiFunctionExperiment.divide.apply(6, 3), "Dividing 6 by 3 should return 2");
        assertEquals(0, BiFunctionExperiment.divide.apply(2, 3), "Dividing 2 by 3 should return 0");
        assertEquals(-2, BiFunctionExperiment.divide.apply(-6, 3), "Dividing -6 by 3 should return -2");
        assertEquals(4, BiFunctionExperiment.divide.apply(20, 5), "Dividing 20 by 5 should return 4");
    }

    @Test
    void subtract_ShouldSubtractTwoNumbers() {
        assertEquals(0, BiFunctionExperiment.subtract.apply(0, 0), "Subtracting 0 from 0 should return 0");
        assertEquals(-1, BiFunctionExperiment.subtract.apply(2, 3), "Subtracting 3 from 2 should return -1");
        assertEquals(-5, BiFunctionExperiment.subtract.apply(-3, 2), "Subtracting 2 from -3 should return -5");
        assertEquals(20, BiFunctionExperiment.subtract.apply(60, 40), "Subtracting 40 from 60 should return 20");
    }

    @Test
    void process2And3_ShouldApplyFunctionToTwoAndThree() {
        assertEquals(5, BiFunctionExperiment.process2And3(BiFunctionExperiment.add), "Processing 2 and 3 with add should return 5");
        assertEquals(6, BiFunctionExperiment.process2And3(BiFunctionExperiment.multiply), "Processing 2 and 3 with multiply should return 6");
        assertEquals(0, BiFunctionExperiment.process2And3(BiFunctionExperiment.divide), "Processing 2 and 3 with divide should return 0");
        assertEquals(-1, BiFunctionExperiment.process2And3(BiFunctionExperiment.subtract), "Processing 2 and 3 with subtract should return -1");
    }


    
} 