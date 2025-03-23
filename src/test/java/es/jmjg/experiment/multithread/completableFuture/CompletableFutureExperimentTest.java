package es.jmjg.experiment.multithread.completableFuture;

import es.jmjg.experiment.multithread.completablefuture.CompletableFutureExperiment;
import es.jmjg.experiment.shared.CaptureConsoleOutputTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

class CompletableFutureExperimentTest extends CaptureConsoleOutputTest {
    private final CompletableFutureExperiment completableFutureExperiment = new CompletableFutureExperiment();

    @Test
    void testFutureToCompletableFuture() {
        List<String> expectedOutput = Arrays.asList(
            "Future starts",
            "Test ends",
            "HELLO FROM FUTURE TEST01!"
        );

        completableFutureExperiment.futureToCompletableFuture();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testSupplyAsync() {
        List<String> expectedOutput = Arrays.asList(
            "Test ends",
            "Hello from Future test02!"
        );

        completableFutureExperiment.supplyAsync();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testAllOf() {
        List<String> expectedOutput = Arrays.asList(
            "3",
            "[Task 1 Result, Task 2 Result, Task 3 Result]"
        );

        completableFutureExperiment.allOf();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testCompletableFutureComplete() {
        List<String> expectedOutput = Arrays.asList(
            "Before calculateAsync",
            "After calculateAsync",
            "Before get",
            "Executing calculateAsync",
            "Hello",
            "After get"
        );

        completableFutureExperiment.completableFutureComplete();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenAccept() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Computation returned: Hello",
            "Finished"
        );

        completableFutureExperiment.thenAccept();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenApply() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = List.of(
            "Hello World"
        );

        completableFutureExperiment.thenApply();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenRun() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = List.of(
            "Computation finished."
        );

        completableFutureExperiment.thenRun();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenCompose() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Before declaring completableFuture",
            "Inside completablefuture",
            "Inside compose",
            "Before get",
            "Hello World",
            "After get"
        );

        completableFutureExperiment.thenCompose();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenComposeV2() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = List.of(
            "20"
        );

        completableFutureExperiment.thenComposeV2();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenCombine() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = List.of(
            "Hello World"
        );

        completableFutureExperiment.thenCombine();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testThenAcceptBoth() throws InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Before declaring completableFuture",
            "Hello World",
            "After declaring completableFuture"
        );

        completableFutureExperiment.thenAcceptBoth();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testAllOfV2() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = List.of(
            "Hello Beautiful World"
        );

        completableFutureExperiment.allOfV2();

        assertOutputIs(expectedOutput);
    }

    @Test
    void testHandle() throws ExecutionException, InterruptedException {
        List<String> expectedOutput = Arrays.asList(
            "Hello, Stranger!",
            "Hello, Patata!"
        );

        completableFutureExperiment.handle();

        assertOutputIs(expectedOutput);
    }
}

