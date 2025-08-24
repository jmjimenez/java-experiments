package es.jmjg.experiment.unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestExceptionIsThrownTest {

    @Test
    void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
