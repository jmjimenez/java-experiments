package es.jmjg.experiment.multithread.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorService {
    private final java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void executeRunnable() {
        Runnable runnableTask = () -> {
            try {
                System.out.println("runnableTask");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executorService.execute(runnableTask);
        shutdownExecutor();
    }

    public void executeCallable() {
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        try {
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
            futures.forEach((future) -> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        shutdownExecutor();
    }

    public void executeAndShutdown() {
        Runnable runnableTask = () -> {
            try {
                System.out.println("runnableTask starts");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("runnableTask ends");
            } catch (InterruptedException e) {
                System.out.println("runnableTask interrupted");
            }
        };

        System.out.println("Executor starts");
        executorService.execute(runnableTask);
        shutdownExecutor();
        System.out.println("Executor ends");
    }

    public boolean executeAndAwait() throws InterruptedException {
        Runnable task = () -> {
            try {
                System.out.println("runnableTask starts");
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("runnableTask ends");
            } catch (InterruptedException e) {
                System.out.println("runnableTask interrupted");
            }
        };

        System.out.println("Executor starts");
        executorService.execute(task);
        //TODO: I don't fully understand return value of awaitTermination
        boolean isTerminated = executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("Executor ends");

        return isTerminated;
    }

    private void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
