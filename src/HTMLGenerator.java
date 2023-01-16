import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator<writer> {
    private Writer writer;

    public HTMLGenerator() throws IOException {
        this.writer = new FileWriter("./index.html");
    }

    public void generate(List<Movie> movie) {
        try {
            String head =
                    """
                            <!doctype html>
                            <html lang="en">
                            <head>
                                <meta charset=\"utf-8\">
                                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                                <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">					
                            </head>
                            <body>
                                    <section class=\"bg-dark text-secondary px-4 py-5 text-center\">
                                        <div class=\"py-5\">
                                          <h1 class=\"display-5 fw-bold text-white\">Top 250 Filmes do IMDB</h1>
                                          <div class=\"col-lg-6 mx-auto\">
                                            <p class=\"fs-5 mb-4\">Essa lista contem os principais 250 Filmes rankeados no IMDB</p>
                                          </div>
                                        </div>
                                      </section>
                                <div class=\"album py-5 bg-dark\">
                                    <div class=\"container\">
                                        <div class=\"row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3\">
                                
                                        
                            """;

            String divTemplate =
                    """
                            <div class=\"col\">
                                <div class=\"card text-bg-dark mb-3\" style=\"max-width: 33rem;\">
                                    <div class=\"row g-0\">
                                        <div class=\"col-md-4\">
                                            <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                                        </div>
                                        <div class=\"col-md-8\">
                                            <div class=\"card-body\">
                                                <h5 class=\"card-title\">%s</h4>    
                                                <p class=\"card-text\">Ano: %s</p>
                                                <p class=\"card-text\">Nota: %s</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    """;

            String end =
                    """
                            </div>
                            </div>
                            </div>
                            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>
                        </body>
                    </html>
                    """;
            writer.write(head);
            for (int i = 0; i < movie.size(); i++) {
                writer.write(String.format(divTemplate, movie.get(i).getImage(), movie.get(i).getTitle(), movie.get(i).getTitle(), movie.get(i).getYear(), movie.get(i).getImDbRating(), movie.get(i).getCrew()));
            }
            writer.write(end);
            writer.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    };
}
