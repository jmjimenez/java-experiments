package es.jmjg.experiment.functional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LambdaExperimentTest {

    @Test
    void add_ShouldAddTwoNumbers() {
        assertEquals(3, LambdaExperiment.add.operate(1, 2));
    }

    @Test
    void subtract_ShouldSubtractTwoNumbers() {
        assertEquals(1, LambdaExperiment.subtract.operate(3, 2));
        assertEquals(-1, LambdaExperiment.subtract.operate(2, 3));
        assertEquals(0, LambdaExperiment.subtract.operate(5, 5));
    }

    @Test
    void multiply_ShouldMultiplyTwoNumbers() {
        assertEquals(6, LambdaExperiment.multiply.operate(2, 3));
        assertEquals(0, LambdaExperiment.multiply.operate(0, 5));
        assertEquals(-10, LambdaExperiment.multiply.operate(2, -5));
        assertEquals(25, LambdaExperiment.multiply.operate(5, 5));
    }

    @Test
    void divide_ShouldDivideTwoNumbers() {
        assertEquals(2, LambdaExperiment.divide.operate(6, 3));
        assertEquals(0, LambdaExperiment.divide.operate(0, 5));
        assertEquals(-2, LambdaExperiment.divide.operate(-6, 3));
        assertEquals(1, LambdaExperiment.divide.operate(5, 5));
    }

    @Test
    void divide_ShouldThrowArithmeticException_WhenDividingByZero() {
        assertThrows(ArithmeticException.class, () -> {
            LambdaExperiment.divide.operate(5, 0);
        });
    }
}