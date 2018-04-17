/**
 * Created by tom on 9/04/2018.
 */
import java.lang.Math;

public class Polygon {

    private int pointNum;           //This is the number of points in the polygon
    private Point[] sequence;      //This is the array of points in the polygon

    //constructor. The polygon MUST be given a size.
    Polygon(int numPoints) {
        pointNum = numPoints;           //assigning number of points
        sequence = new Point[pointNum]; //initializing the already declared array of points.

        for (int i = 0; i < numPoints; i++) { //Populating array with Points.
            sequence[i] = new Point();
        }
    }

    //Will return a point in a location in sequence array. It will return a pointer to a point.
    public Point getPoint(int index) {
        return sequence[index];
    }

    //Formats the points of the polygon and it's area and returns as a string.
    public String polyToString() {

        String theString = "[";
        //The last point in sequence is repeated so we don't want to print it hence i<pointNum-1.
        for (int i = 0; i < pointNum - 1; i++) {
            theString += sequence[i].pointToString();
            if (i != pointNum - 2) {
                theString += ", ";
            }
        }
        theString += "]:" + String.format("%5.2f", calcArea());
        return theString;
    }

    //Calculates the area inside of the polygon.
    public double calcArea() {
        double area = 0;
        double interimResult = 0;
        //"n" form the formula is 1 more than the number of points on the polygon. This is not considered anywhere so we
        // modify the formula to be (n-1) instead of (n-2).
        for (int i = 0; i < (pointNum - 1); i++) {
            interimResult = (sequence[i + 1].getX() + sequence[i].getX()) * (sequence[i + 1].getY() - sequence[i].getY());
            area += interimResult;
        }

        return (0.5 * Math.abs(area));
    }

    //Returns the distance of the point closest to the origin. For some reason.
    public double closestOrigin() {
        //initialize the distance to one of the points.
        double distance = sequence[0].distOrigin();
        for (int i = 0; i < pointNum; i++) {
            if (distance > sequence[i].distOrigin()) {
                distance = sequence[i].distOrigin();
            }
        }

        return distance;
    }

    //This is for comparing polygons. Must be updated to work using abstract class ComparePolygons.
    //Returns true is the new polygon is bigger than the old polygon.
    //If new polygon is the same size or within 0.05% of old polygon returns true.
    public boolean comparePolygons(Polygon newPolygon) {
        boolean state = false;

        //NOT RETURNING A TRUE OR FALSE IN SOME CASE.
        double areaOld = calcArea();
        double areaNew = newPolygon.calcArea();
        //This is 0.05% of the area of the old polygon.
        double variation = 0.0005 * calcArea();
        //New polygon's area must be between these values to be counted as "equal".
        double upperLimit = calcArea() + variation;
        double lowerLimit = calcArea() - variation;

        //If new bigger than old.
        if (areaOld < areaNew) {
            //if this is false it doesn't work. Works if true.
            return true;
        }
        //If they're 'equal' check which is closest to origin.
        else if (areaOld == areaNew || areaNew <= upperLimit && areaOld >= lowerLimit) {
            //The new polygon was closest to the origin so return it as the largest.
            if (closestOrigin() >= newPolygon.closestOrigin()) {
                return true;
            } else return false;

        }
        //none of the criteria were met so return false.
        else return false;
    }
}
