package es.jmjg.experiment.multithread.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBatchExperiment {

    public List<String> testBatch(List<String> textsToSummarize) {
        int batchSize = 10;
        int totalBatches = (textsToSummarize.size() + batchSize - 1) / batchSize;
        List<String> summarized = new ArrayList<>();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < totalBatches; i++) {
                int start = i * batchSize;
                int end = Math.min(start + batchSize, textsToSummarize.size());
                List<String> batch = textsToSummarize.subList(start, end);

                List<CompletableFuture<String>> futures = batch.stream()
                    .map(text -> CompletableFuture.supplyAsync(() -> {
                        try {
                            return text;
                        } catch (Exception e) {
                            return null;
                        }
                    }, executor))
                    .toList();

                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
                List<String> summarizedBatch = futures.stream()
                    .map(CompletableFuture::join)
                    .filter(Objects::nonNull)
                    .toList();

                summarized.addAll(summarizedBatch);
            }
        }
        
        return summarized;
    }
}
