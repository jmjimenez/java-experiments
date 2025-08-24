package es.jmjg.experiment.multithread.completableFuture;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.jmjg.experiment.multithread.completablefuture.CompletableFutureBatchExperiment;

class CompletableFutureBatchExperimentTest {
    
    private CompletableFutureBatchExperiment batchExperiment;

    @BeforeEach
    void setUp() {
        batchExperiment = new CompletableFutureBatchExperiment();
    }

    @Test
    void testBatch_WithEmptyList() {
        List<String> emptyList = List.of();
        
        List<String> result = batchExperiment.testBatch(emptyList);
        
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testBatch_WithSingleItem() {
        List<String> singleItem = List.of("Test text");
        
        List<String> result = batchExperiment.testBatch(singleItem);
        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test text", result.get(0));
    }

    @Test
    void testBatch_WithMultipleItems() {
        List<String> multipleItems = Arrays.asList(
            "First text",
            "Second text", 
            "Third text",
            "Fourth text",
            "Fifth text"
        );
        
        List<String> result = batchExperiment.testBatch(multipleItems);
        
        assertNotNull(result);
        assertEquals(5, result.size());
        assertTrue(result.containsAll(multipleItems));
    }

    @Test
    void testBatch_WithBatchSizeExceeding() {
        List<String> largeList = Arrays.asList(
            "Text 1", "Text 2", "Text 3", "Text 4", "Text 5",
            "Text 6", "Text 7", "Text 8", "Text 9", "Text 10"
        );
        
        List<String> result = batchExperiment.testBatch(largeList);
        
        assertNotNull(result);
        assertEquals(10, result.size());
        assertTrue(result.containsAll(largeList));
    }

    @Test
    void testBatch_WithNullValues() {
        List<String> listWithNulls = Arrays.asList(
            "Valid text 1",
            null,
            "Valid text 2",
            null,
            "Valid text 3"
        );
        
        List<String> result = batchExperiment.testBatch(listWithNulls);
        
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains("Valid text 1"));
        assertTrue(result.contains("Valid text 2"));
        assertTrue(result.contains("Valid text 3"));
        assertFalse(result.contains(null));
    }

    @Test
    void testBatch_WithLargeNumberOfItems() {
        // Create a list with exactly batch size + 1 items to test batch boundary
        List<String> largeList = new java.util.ArrayList<>();
        for (int i = 0; i < 301; i++) {
            largeList.add("Text " + i);
        }
        
        List<String> result = batchExperiment.testBatch(largeList);
        
        assertNotNull(result);
        assertEquals(301, result.size());
        
        // Verify all items are present
        for (int i = 0; i < 301; i++) {
            assertTrue(result.contains("Text " + i));
        }
    }
}
