import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImdbMovie implements Content {

    private String id;
    private String title;
    private String year;
    private String image;
    private String imDbRating;

    @JsonCreator
    public ImdbMovie(
            @JsonProperty("id") final String id,
            @JsonProperty("title") final String title,
            @JsonProperty("year") final String year,
            @JsonProperty("image") final String image,
            @JsonProperty("imDbRating") final String imDbRating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.imDbRating = imDbRating;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String getRating() {
        return imDbRating;
    }
}
