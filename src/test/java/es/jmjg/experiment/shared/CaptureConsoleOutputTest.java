package es.jmjg.experiment.shared;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.mockito.Mockito.*;

abstract public class CaptureConsoleOutputTest extends AbstractCaptureOutput {
    private final PrintStream originalOut = System.out;

    protected PrintStream mockOut;

    @BeforeEach
    void setUp() {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    protected void assertOutputIs(List<String> expectedOutput) {
        int numberOfExpectedLines = expectedOutput.size();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockOut, times(numberOfExpectedLines)).println(captor.capture());
        Assertions.assertEquals(expectedOutput, captor.getAllValues());
    }

    protected void assertOutputIs(String expectedOutput) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockOut, times(1)).println(captor.capture());
        assertEquals(expectedOutput,  captor.getValue());
    }

    protected void assertOutputMatches(List<String> expectedOutput) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockOut, times(expectedOutput.size())).println(captor.capture());
        assertLinesMatch(expectedOutput,  captor.getAllValues());
    }
}
