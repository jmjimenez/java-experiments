package es.jmjg.experiment.multithread.completablefuture;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBatchExperiment {

    public List<String> testBatch(List<String> textsToSummarize) {
        int batchSize = 20;
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
                            return makeHttpRequest(text);
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

    private String makeHttpRequest(String text) throws IOException, InterruptedException {
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        String url = "https://postman-echo.com/get?text=" + encodedText;
        
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return extractTextFromResponse(response.body());
        }
    }
    
    private String extractTextFromResponse(String jsonResponse) {
        try {
            // Simple JSON parsing to extract args.text
            int argsStart = jsonResponse.indexOf("\"args\":");
            if (argsStart == -1) {
                return jsonResponse; // Return original response if parsing fails
            }
            
            int textStart = jsonResponse.indexOf("\"text\":", argsStart);
            if (textStart == -1) {
                return jsonResponse; // Return original response if parsing fails
            }
            
            // Find the start of the text value (after the colon and quote)
            int valueStart = jsonResponse.indexOf("\"", textStart + 7) + 1;
            if (valueStart == 0) {
                return jsonResponse; // Return original response if parsing fails
            }
            
            // Find the end of the text value (next quote)
            int valueEnd = jsonResponse.indexOf("\"", valueStart);
            if (valueEnd == -1) {
                return jsonResponse; // Return original response if parsing fails
            }
            
            return jsonResponse.substring(valueStart, valueEnd);
        } catch (Exception e) {
            return jsonResponse; // Return original response if parsing fails
        }
    }
}
