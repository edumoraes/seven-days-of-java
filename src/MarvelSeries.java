import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MarvelSeries implements Content {
    private int id;
    private String title;
    private String year;
    private String image;
    private String pathImage;
    private String extensionImage;

    @JsonCreator
    public MarvelSeries(
            @JsonProperty("id") final int id,
            @JsonProperty("title") final String title,
            @JsonProperty("startYear") final String year,
            @JsonProperty("path") final String pathImage,
            @JsonProperty("extension") final String extensionImage) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = pathImage + "." + extensionImage;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }
}