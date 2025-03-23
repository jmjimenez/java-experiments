package es.jmjg.experiment.testing.moco;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Moco;
import com.github.dreamhead.moco.Runner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.dreamhead.moco.Moco.*;
import static java.net.http.HttpClient.newHttpClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MocoTest {
    Runner runner;
    final Integer port = 12345;

    @BeforeEach
    public void setup() {
        HttpServer server = Moco.httpServer(port); // Initialize server on port 12345

        server.request(Moco.by(Moco.uri("/hello")))
            .response(Moco.text("Hello, Moco!")); // Set up a basic response

        server.request(by(uri("/api/user")))
            .response(header("Content-Type", "application/json"))
            .response(json("{\"id\": 1, \"name\": \"Ryland Grace\", \"email\": \"ryland.grace@example.com\"}"));

        runner = Runner.runner(server);
        runner.start(); // Start the server
    }

    @AfterEach
    public void teardown() {
        runner.stop();
    }

    @Test
    public void testPatata() {
        HttpResponse<String> response;

        try (HttpClient client = newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/hello"))
                .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Hello, Moco!", response.body());
    }
}
