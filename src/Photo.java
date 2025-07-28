import java.time.LocalDate;
import java.util.Set;

public class Photo {
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private double latitude;
    private double longitude;
    private Set<String> tags;

    public Photo(String id, String name, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tags;
        if (PhotoManager.getZones().containsKey(location)) {
            CoordinatesZone zone = PhotoManager.getZones().get(location);
            if (zone.isInZone(latitude, longitude)) {
                latitude = zone.getLatitude();
                longitude = zone.getLongitude();
            }
        }
    }
    public Photo(String id, String name, LocalDate date, double latitude, double longitude, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = tags;
        this.location = "";
    }

    public Set<String> getTags() {
        return tags;
    }
    public String getLocation() {
        return location;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + date + " " + location;
    }
}
