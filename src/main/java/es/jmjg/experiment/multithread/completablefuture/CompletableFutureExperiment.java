package es.jmjg.experiment.multithread.completablefuture;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExperiment {
    public void futureToCompletableFuture() {
        final String[] result = new String[1];

        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<String> future;

            future = executor.submit(() -> {
                System.out.println("Future starts");
                Thread.sleep(1000);
                return "Hello from Future test01!";
            });

            CompletableFuture<String> completableFuture = toCompletableFuture(future, executor);

            completableFuture
                .thenApply(String::toUpperCase)
                .thenAccept(futureResult -> result[0] = futureResult);

            executor.shutdown();
        }

        System.out.println("Test ends");

        System.out.println(result[0]);
    }

    public void supplyAsync() {
        final String[] result = new String[1];

        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<String> future = executor.submit(() -> {
                Thread.sleep(1000);
                return "Hello from Future test02!";
            });

            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            completableFuture.thenAccept(futureResult -> result[0] = futureResult);

            executor.shutdown();
        }

        System.out.println("Test ends");

        System.out.println(result[0]);
    }

    public void allOf() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = List.of(
            executor.submit(() -> {
                return "Task 1 Result";
            }),
            executor.submit(() -> {
                return "Task 2 Result";
            }),
            executor.submit(() -> {
                return "Task 3 Result";
            })
        );

        CompletableFuture<Void> allOf = allOf(futures, executor);

        allOf.thenRun(() -> {
            try {
                List<String> results = futures.stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
                System.out.println(String.valueOf(results.size()));
                System.out.println(results.toString());
            } catch (Exception ignored) {
            }
        }).join();

        executor.shutdown();
    }

    public void allOfV2() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();
        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        System.out.println(future3.isDone());

        String combined = Stream.of(future1, future2, future3)
            .map(CompletableFuture::join)
            .collect(Collectors.joining(" "));
        System.out.println(combined);
        executor.shutdown();
    }

    public void completableFutureComplete() {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            System.out.println("Before calculateAsync");
            Future<String> future = calculateAsync(executor);
            System.out.println("After calculateAsync");
            System.out.println("Before get");
            System.out.println(future.get());
            System.out.println("After get");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

    public void thenAccept() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = CompletableFuture
            .thenAccept(s -> System.out.println("Computation returned: " +s));

        future.get();

        future.thenAccept(s -> System.out.println("Finished"));
        executor.shutdown();
    }

    public void thenApply() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = CompletableFuture.thenApply(s -> s + " World");
        System.out.println(future.get());
        executor.shutdown();
    }

    public void thenRun() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = CompletableFuture.thenRun(() -> System.out.println("Computation finished."));
        future.get();
        executor.shutdown();
    }

    public void thenCompose() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println("Before declaring completableFuture");
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Inside completablefuture");
                return "Hello";
            })
            .thenCompose(s -> {
                System.out.println("Inside compose");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return java.util.concurrent.CompletableFuture.supplyAsync(() -> s + " World");
            });
        Thread.sleep(500);
        System.out.println("Before get");
        System.out.println(CompletableFuture.get());
        System.out.println("After get");
        executor.shutdown();
    }

    public void thenComposeV2() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<Integer> finalResult = compute().thenCompose(this::computeAnother);

        System.out.println(String.valueOf(finalResult.get()));
        executor.shutdown();
    }

    public void thenCombine() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenCombine(
                java.util.concurrent.CompletableFuture.supplyAsync(() -> " World"),
                (s1, s2) -> s1 + s2
            );
        System.out.println(CompletableFuture.get());
        executor.shutdown();
    }

    public void thenAcceptBoth() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println("Before declaring completableFuture");
        CompletableFuture
            .supplyAsync(() -> "Hello")
            .thenAcceptBoth(
                CompletableFuture.supplyAsync(() -> " World"),
                (s1, s2) -> System.out.println(s1 + s2))
            ;
        Thread.sleep(2000);
        System.out.println("After declaring completableFuture");
        executor.shutdown();
    }

    public void handle() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        System.out.println(sayHello(null).get());
        System.out.println(sayHello("Patata").get());
        executor.shutdown();
    }

    private CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name + "!";
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
    }

    private Future<String> calculateAsync(ExecutorService executor) throws InterruptedException {
        CompletableFuture<String> CompletableFuture = new CompletableFuture<>();

        executor.submit(() -> {
            System.out.println("Executing calculateAsync");
            Thread.sleep(500);
            CompletableFuture.complete("Hello");
            return null;
        });
        return CompletableFuture;
    }

    private CompletableFuture<Integer> compute(){
        return CompletableFuture.supplyAsync(() -> 10);
    }

    private CompletableFuture<Integer> computeAnother(Integer i){
        return CompletableFuture.supplyAsync(() -> 10 + i);
    }

    static CompletableFuture<Void> allOf(List<Future<String>> futures, ExecutorService executor) {
        List<CompletableFuture<String>> completableFutures = futures.stream()
            .map(future -> toCompletableFuture(future, executor))
            .toList();

        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
    }

    static <T> java.util.concurrent.CompletableFuture<T> toCompletableFuture(Future<T> future, ExecutorService executor) {
        java.util.concurrent.CompletableFuture<T> completableFuture = new java.util.concurrent.CompletableFuture<>();
        executor.submit(() -> {
            try {
                completableFuture.complete(future.get());
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        });
        return completableFuture;
    }
}
