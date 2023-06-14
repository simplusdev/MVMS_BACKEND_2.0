package sg.com.simplus.mvms.framework.util;

import java.util.ArrayList;

public class GeoMetrics {
    //Checks if a point is within a polygon defined by a list of geo coordinates
    public static boolean isInsidePolygon(double latitude, double longitude, ArrayList<Double> arrayList_latitude, ArrayList<Double> arrayList_longitude) {
        final double PI = 3.14159265;
        ArrayList<Double> arrayList_double_latitude = new ArrayList<Double>();
        ArrayList<Double> arrayList_double_longitude = new ArrayList<Double>();

        for (Double double_latitude : arrayList_latitude) {
            arrayList_double_latitude.add(double_latitude);
        }

        for (Double double_longitude : arrayList_longitude) {
            arrayList_double_longitude.add(double_longitude);
        }

        double angle = 0;
        double point1_lat;
        double point1_long;
        double point2_lat;
        double point2_long;
        int n = arrayList_double_latitude.size();

        for (int int_index = 0; int_index < n; int_index++) {
            point1_lat = arrayList_double_latitude.get(int_index) - latitude;
            point1_long = arrayList_double_longitude.get(int_index) - longitude;
            point2_lat = arrayList_double_latitude.get((int_index + 1) % n) - latitude;
            point2_long = arrayList_double_longitude.get((int_index + 1) % n) - longitude;
            angle += Angle2D(point1_lat, point1_long, point2_lat, point2_long);
        }

        if (Math.abs(angle) < PI) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isInsideCircle(double latitude1, double longitude1, double latitude2, double longitude2, double radius) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = 0;//el1 - el2

        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        distance = Math.sqrt(distance);

        return distance < radius;
    }

    private static double Angle2D(double y1, double x1, double y2, double x2) {
        double PI = 3.14159265;
        double TWOPI = 2 * PI;
        double dtheta, theta1, theta2;

        theta1 = Math.atan2(y1, x1);
        theta2 = Math.atan2(y2, x2);
        dtheta = theta2 - theta1;
        while (dtheta > PI) {
            dtheta -= TWOPI;
        }
        while (dtheta < -PI) {
            dtheta += TWOPI;
        }

        return (dtheta);
    }
}
