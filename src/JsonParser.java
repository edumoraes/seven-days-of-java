import java.io.IOException;
import java.util.List;

public interface JsonParser {
    List<Content> generateList(String responseBody) throws IOException;
}
