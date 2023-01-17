import java.io.IOException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ImdbApiClient top250Movies = new ImdbApiClient("URI_API");
        ImdbParser parser = new ImdbParser();
        HTMLGenerator html = new HTMLGenerator();
        html.generate(parser.generateList(top250Movies.response().body()));
    }
}