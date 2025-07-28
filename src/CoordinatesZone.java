public class CoordinatesZone {
    private double latitude;
    private double longitude;
    private double radius;

    public CoordinatesZone(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public boolean isInZone(double search_lat, double search_lon) {
        final int EARTH_RADIUS_M = 6378137; // I did this function before but in embedded C for a uni project.
        // I am assuming that the latitude and longitude are both in degree decimal.
        double latDistance = Math.toRadians(search_lat - latitude);
        double lonDistance = Math.toRadians(search_lon - longitude);
        double a = Math.pow(Math.sin(latDistance / 2), 2) + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(search_lat)) * Math.pow(Math.sin(lonDistance / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS_M * c) <= (radius * 1000); // Return true if location specified is inside the zone.
    }
    public static boolean inZone(Photo photo,double search_lat, double search_lon, double radius) {
        final int EARTH_RADIUS_M = 6378137;
        double latDistance = Math.toRadians(search_lat - photo.getLatitude());
        double lonDistance = Math.toRadians(search_lon - photo.getLongitude());
        double a = Math.pow(Math.sin(latDistance / 2), 2) + Math.cos(Math.toRadians(photo.getLatitude())) * Math.cos(Math.toRadians(search_lat)) * Math.pow(Math.sin(lonDistance / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (EARTH_RADIUS_M * c) <= (radius * 1000); // Return true if location specified is inside the zone.
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }
}
