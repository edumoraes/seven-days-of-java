import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser {
    @Override
    public List<Content> generateList(String responseBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseNode = objectMapper
                .readTree(responseBody)
                .path("items"); //parse to Jackson JsonNode
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //Exception double quote
        CollectionType collectionType = TypeFactory
                .defaultInstance()
                .constructCollectionType(List.class, ImdbMovie.class);
        List<Content> listMovies = objectMapper
                .reader(collectionType)
                .readValue(responseNode);
        return listMovies;
    }

}
