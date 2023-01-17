import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie implements Content {

    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    @JsonCreator
    public Movie(
            @JsonProperty("id") final String id,
            @JsonProperty("rank") final String rank,
            @JsonProperty("title") final String title,
            @JsonProperty("fullTitle") final String fullTitle,
            @JsonProperty("year") final String year,
            @JsonProperty("image") final String image,
            @JsonProperty("crew") final String crew,
            @JsonProperty("imDbRating") final String imDbRating,
            @JsonProperty("imDbRatingCount") final String imDbRatingCount) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.fullTitle = fullTitle;
        this.year = year;
        this.image = image;
        this.crew = crew;
        this.imDbRating = imDbRating;
        this.imDbRatingCount = imDbRatingCount;
    }

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }
}
