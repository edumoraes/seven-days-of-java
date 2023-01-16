import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(System.getenv("URI_API")))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Parser
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode responseNode = objectMapper
                .readTree(response.body())
                .path("items"); //parse to Jackson JsonNode

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //Exception double quote

        CollectionType collectionType = TypeFactory
                .defaultInstance()
                .constructCollectionType(List.class, Movie.class);

        List<Movie> listMovies = objectMapper
                .reader(collectionType)
                .readValue(responseNode);



        HTMLGenerator html = new HTMLGenerator();

        html.generate(listMovies);



    }
}