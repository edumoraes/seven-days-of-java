import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MarvelSeries implements Content {
    private int id;
    private String title;
    private String year;
    private String image;
    private String imagePath;
    private String imageExtension;

    @JsonCreator
    public MarvelSeries(
            @JsonProperty("id") final int id,
            @JsonProperty("title") final String title,
            @JsonProperty("startYear") final String year,
            @JsonProperty("path") final String imagePath,
            @JsonProperty("extension") final String imageExtension) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = imagePath + "." + imageExtension;
    }

    @Override
    public String getId() {
        String idString = Integer.toString(id);
        return idString;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getYear() {
        return year;
    }
    @Override
    public String getImage() {
        return image;
    }
    @Override
    public String getRating() {
        return "Sem valor";
    }
}