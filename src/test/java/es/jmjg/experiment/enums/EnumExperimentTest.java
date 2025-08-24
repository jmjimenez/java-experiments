package es.jmjg.experiment.enums;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EnumExperimentTest {

    private static final int FIRST_OPERAND = 10;
    private static final int SECOND_OPERAND = 3;
    private static final int ZERO_OPERAND = 0;

    @Test
    void add_ShouldAddTwoNumbers() {
        assertEquals(13, EnumExperiment.MathOperationEnum.ADD.apply(FIRST_OPERAND, SECOND_OPERAND));
    }

    @Test
    void subtract_ShouldSubtractTwoNumbers() {
        assertEquals(7, EnumExperiment.MathOperationEnum.SUBTRACT.apply(FIRST_OPERAND, SECOND_OPERAND));
    }

    @Test
    void multiply_ShouldMultiplyTwoNumbers() {
        assertEquals(30, EnumExperiment.MathOperationEnum.MULTIPLY.apply(FIRST_OPERAND, SECOND_OPERAND));
    }

    @Test
    void divide_ShouldDivideTwoNumbers() {
        assertEquals(3, EnumExperiment.MathOperationEnum.DIVIDE.apply(FIRST_OPERAND, SECOND_OPERAND));
    }

    @Test
    void divide_ShouldThrowArithmeticException_WhenDividingByZero() {
        assertThrows(ArithmeticException.class, () -> 
            EnumExperiment.MathOperationEnum.DIVIDE.apply(FIRST_OPERAND, ZERO_OPERAND)
        );
    }
}
