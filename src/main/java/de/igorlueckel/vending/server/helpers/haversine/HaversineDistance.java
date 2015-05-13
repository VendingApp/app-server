package de.igorlueckel.vending.server.helpers.haversine;

/**
 * This is the implementation Haversine Distance Algorithm between two places
 * @author ananth
 *  R = earth’s radius (mean radius = 6,371km)
    Δlat = lat2− lat1
    Δlong = long2− long1
    a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
    c = 2.atan2(√a, √(1−a))
    d = R.c
 *
 * See https://bigdatanerd.wordpress.com/2011/11/03/java-implementation-of-haversine-formula-for-distance-calculation-between-two-points/
 * See http://www.movable-type.co.uk/scripts/latlong.html#destPoint
 */
public class HaversineDistance {

    /**
     *
     * @param lat1
     * @param long1
     * @param lat2
     * @param long2
     * @return
     */
    public static double calculateDistance(double lat1, double long1, double lat2, double long2) {
        final int R = 6371; // Radious of the earth
        double latDistance = toRad(lat2-lat1);
        double lonDistance = toRad(long2-long1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;

       return distance;
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

    /**
     *
     * @param latitude Latitude of the center point
     * @param longitude Longitude of the center point
     * @param distance Distance from the center point in km
     * @return Returns a rectangle with longitudes and latitudes that are so far away as specified in <i>distance</i>
     */
    public static RectangleBound calculateBounds(double latitude, double longitude, double distance) {
        final int R = 6371; // Radious of the earth
        double latNorth = Math.asin( Math.sin(latitude)*Math.cos(distance/R) +  Math.cos(latitude)*Math.sin(distance/R)*Math.cos(0));
        double latSouth = Math.asin( Math.sin(latitude)*Math.cos(distance/R) +  Math.cos(latitude)*Math.sin(distance/R)*Math.cos(180));
        double longEast = longitude + Math.atan2(Math.sin(90)*Math.sin(distance/R)*Math.cos(latitude), Math.cos(distance/R)-Math.sin(latitude)*Math.sin(latSouth));
        double longWest = longitude + Math.atan2(Math.sin(270)*Math.sin(distance/R)*Math.cos(latitude), Math.cos(distance/R)-Math.sin(latitude)*Math.sin(latNorth));
        return new RectangleBound(latNorth, latSouth, longEast, longWest);
    }


}
