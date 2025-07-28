import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhotoManager {
    ArrayList<Photo> photos; // I chose a list as photos can be duplicated in a photo manager

    public static Map<String,CoordinatesZone> getZones() {
        Map<String,CoordinatesZone> zones = new HashMap<>();
        zones.put("Cairo", new CoordinatesZone("Cairo", 30.0444, 31.2357, 30));
        zones.put("Alexandria", new CoordinatesZone("Alexandria", 31.2001, 29.9187, 20));
        zones.put("Giza", new CoordinatesZone("Giza", 29.9870, 31.2118, 15));
        return zones;
    }

    public PhotoManager() {
        photos = new ArrayList<>();
    }

    public void uploadPhoto(Photo photo) {
        photos.add(photo);
    }
    public ArrayList<Photo> searchByTag(String tag) {

    }
    public ArrayList<Photo> searchByDate(LocalDate date) {

    }
    public ArrayList<Photo> searchByLocation(String location) {

    }
    public ArrayList<Photo> searchByMultipleTags(Set<String> tags) {

    }


}
