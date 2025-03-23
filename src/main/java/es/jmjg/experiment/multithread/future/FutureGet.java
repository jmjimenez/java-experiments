package es.jmjg.experiment.multithread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureGet {
    public void execute() {
        String result;

        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<String> future = executor.submit(() -> {
                System.out.println("Future starts");
                Thread.sleep(1000);
                return "Hello from Future!";
            });

            try {
                System.out.println("Get future");
                result = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            executor.shutdown();
        }

        System.out.println(result);
    }
}
