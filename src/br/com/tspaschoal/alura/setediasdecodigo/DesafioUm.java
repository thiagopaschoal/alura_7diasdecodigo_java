package br.com.tspaschoal.alura.setediasdecodigo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DesafioUm {

    private static final String BASE_URL = "https://imdb-api.com";

    private static final String API_TOKEN = "k_8rt57f5x";

    public static void main(String[] args) {
        final var response = getImdbApiResponse();
        System.out.println(response);
    }

    private static String getImdbApiResponse() {
        try {
            final var request = getHttpRequest();
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("erro ao processar requisição", e);
        }
    }

    private static HttpRequest getHttpRequest() {
        try {
            final var uri = new URI(String.format("%s/en/API/Top250Movies/%s", BASE_URL, API_TOKEN));
            return HttpRequest.newBuilder()
                    .GET()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .uri(uri)
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException("erro ao criar uri", e);
        }
    }
}
