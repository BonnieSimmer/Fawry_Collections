import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class PhotoManager {
    private ArrayList<Photo> photos; // I chose a list as photos can be duplicated in a photo manager

    private static Map<String,CoordinatesZone> zones = Map.of (
            "Cairo", new CoordinatesZone( 30.0444, 31.2357, 20),
            "Alexandria", new CoordinatesZone(31.2001, 29.9187, 30),
            "Giza", new CoordinatesZone(29.987, 31.2118, 15)
    );

    public PhotoManager() {
        photos = new ArrayList<>();
    }

    public void uploadPhoto(Photo photo) {
        photos.add(photo);
    }
    public ArrayList<Photo> searchByTag(String tag) {
        ArrayList<Photo> neededPhotos = new ArrayList<>();
        for (Photo photo : photos) {
            if (photo.getTags().contains(tag)) {
                    neededPhotos.add(photo);
            }
        }
        return neededPhotos;
    }
    public ArrayList<Photo> searchByDate(LocalDate date) {
        ArrayList<Photo> neededPhotos = new ArrayList<>();
        for (Photo photo : photos) {
            if (photo.getDate().equals(date)) {
                neededPhotos.add(photo);
            }
        }
        return neededPhotos;
    }
    public ArrayList<Photo> searchByLocation(String location) {
        ArrayList<Photo> neededPhotos = new ArrayList<>();
        for (Photo photo : photos) {
            if (photo.getLocation().equals(location)) {
                neededPhotos.add(photo);
            }
        }
        return neededPhotos;
    }
    public ArrayList<Photo> searchByCoordinates(double latitude, double longitude) {
        ArrayList<Photo> neededPhotos = new ArrayList<>();
        CoordinatesZone zone;
        for (Photo photo : photos) {
            if (zones.containsKey(photo.getLocation())) {
                zone = zones.get(photo.getLocation());
                if (zone.isInZone(latitude, longitude)) {
                    neededPhotos.add(photo);
                }
            }
        }
        return neededPhotos;
    }
    public ArrayList<Photo> searchByMultipleTags(Set<String> tags) {
        ArrayList<Photo> neededPhotos = new ArrayList<>();
        for (Photo photo : photos) {
            for (String tag : tags) {
                if (photo.getTags().contains(tag)) { // we can also use a Set to avoid duplicates but I want to save the order.
                    if (!neededPhotos.contains(photo)) {
                        neededPhotos.add(photo);
                    }
                }
            }
        }
        return neededPhotos;
    }


}
