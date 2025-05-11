package es.jmjg.experiment.functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

class FunctionExperimentTest {
    
    private FunctionExperiment functionExperiment = new FunctionExperiment();
    
    @Test
    void returnTripleFunction_ShouldTripleInput() {
        Function<Integer, Integer> tripleFunction = functionExperiment.returnTripleFunction();

        assertEquals(0, tripleFunction.apply(0), "Tripling 0 should return 0");
        assertEquals(3, tripleFunction.apply(1), "Tripling 1 should return 3");
        assertEquals(6, tripleFunction.apply(2), "Tripling 2 should return 6");
        assertEquals(-9, tripleFunction.apply(-3), "Tripling -3 should return -9");
        assertEquals(30, tripleFunction.apply(10), "Tripling 10 should return 30");
    }

    @Test
    void returnSumFunction_ShouldSumInputWithConstant() {
        Function<Integer, Integer> sumFunction = functionExperiment.returnSumFunction(5);
        
        assertEquals(5, sumFunction.apply(0), "Summing 0 with 5 should return 5");
        assertEquals(6, sumFunction.apply(1), "Summing 1 with 5 should return 6");
        assertEquals(10, sumFunction.apply(5), "Summing 5 with 5 should return 10");
        assertEquals(-2, sumFunction.apply(-7), "Summing -7 with 5 should return -2");
    }   

    @Test
    void returnSumFunction_ShouldSumInputWithTwoConstants() {
        Function<Integer, Integer> sumFunction = functionExperiment.returnSumFunction(5, 10);
        
        assertEquals(15, sumFunction.apply(0), "Summing 0 with 5 and 10 should return 15");
        assertEquals(16, sumFunction.apply(1), "Summing 1 with 5 and 10 should return 16"); 
    }
    
    @Test
    void returnSumFunction_ShouldSumInputWithThreeConstants() {
        Function<Integer, Integer> sumFunction = functionExperiment.returnSumFunction(5, 10);
        
        assertEquals(15, sumFunction.apply(0), "Summing 0 with 5 and 10 should return 15");
        assertEquals(16, sumFunction.apply(1), "Summing 1 with 5 and 10 should return 16");
    }   
    
    @Test
    void process_ShouldMultiplyFunctionResultByConstant() {
        Function<Integer, Integer> tripleFunction = functionExperiment.returnTripleFunction();
        Function<Integer, Integer> processedFunction = functionExperiment.process(2, tripleFunction);
        
        assertEquals(0, processedFunction.apply(0), "Processing triple of 0 times 2 should return 0");
        assertEquals(6, processedFunction.apply(1), "Processing triple of 1 times 2 should return 6");
        assertEquals(12, processedFunction.apply(2), "Processing triple of 2 times 2 should return 12");
        assertEquals(-18, processedFunction.apply(-3), "Processing triple of -3 times 2 should return -18");
        assertEquals(60, processedFunction.apply(10), "Processing triple of 10 times 2 should return 60");
    }
} 