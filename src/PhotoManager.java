import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class PhotoManager {
    ArrayList<Photo> photos; // I chose a list as photos can be duplicated in a photo manager

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
