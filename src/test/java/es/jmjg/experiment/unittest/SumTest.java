package es.jmjg.experiment.unittest;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class SumTest {
    private static final Logger log = LoggerFactory.getLogger(SumTest.class);

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @AfterAll
    static void tearDown() {
        log.info("@AfterAll - executes once after all test methods in this class");
    }

    @AfterEach
    void close() {
        log.info("@AfterEach - executes after each test method in this class");
    }

    @Test
    @DisplayName("Test sum")
    void sum() {
        assertThat(calculator.sum(1,2), is(3));
    }

    @Test
    @DisplayName("Test sum version 2")
    void sum2() {
        assertEquals(3, calculator.sum(1,2), "Sum should work");
    }

    @Test
    @DisplayName("Test sum version 3")
    void sum3() {
        assertTrue(calculator.sum(1,2) == 3, () -> "Sum should work");
    }

    @Test
    @DisplayName("Test minus")
    void minus() {
        assertThat(calculator.minus(1,2), is(-1));
    }

    @Test
    @Disabled
    @DisplayName("Test nothing")
    void nothing() {
        assertThat(false, is(true));
    }

    @Test
    @DisplayName("Testing assumptions")
    void assumptionThat() {
        String someString = "Just a string";
        assumingThat(
            someString.equals("Not the same string"),
            () -> assertEquals(calculator.sum(2, 2), 5)
        );
    }

    @Test
    @DisplayName("Divide by 0 should throw an exception")
    void assertThrowsException() {
        assertThrows(
            ArithmeticException.class,
            () -> { calculator.divide(3, 0); }
        );
    }
}