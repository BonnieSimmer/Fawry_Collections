import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private Set<String> tags;

    public Photo(String id, String name, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }
}
