import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String topImdb = new ApiClient("URI_IMDB").response().body();
        List<Content> parserImdb = new ImdbMovieJsonParser().generateList(topImdb);
        new HTMLGenerator("./topimdb.html").generate(parserImdb);

        /*String seriesMarvel = new ApiClient("URI_MARVEL").response().body();
        List<Content> parserMarvel = new MarvelSerieJsonParser().generateList(seriesMarvel);
        new HTMLGenerator("./marvelseries.html").generate(parserMarvel);*/

    }
}