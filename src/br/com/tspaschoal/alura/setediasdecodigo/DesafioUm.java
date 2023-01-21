package br.com.tspaschoal.alura.setediasdecodigo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DesafioUm {

    private static final String ENDPOINT = "https://imdb-api.com/en/API/Top250Movies/";

    private static final String API_TOKEN = "k_8rt57f5x";

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        final var uri = new URI(String.format("%s%s", ENDPOINT, API_TOKEN));

        final var request = HttpRequest.newBuilder()
                .GET()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(uri)
                .build();

        final var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(response);

    }
}
