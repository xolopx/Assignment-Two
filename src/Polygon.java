/**
 * Created by tom on 9/04/2018.
 */
import java.lang.Math;

public class Polygon extends PlanarShape{

    //constructor. The polygon MUST be given a size.
    Polygon(int numPoints) {
        pointNum = numPoints;           //assigning number of points
        sequence = new Point[pointNum]; //initializing the already declared array of points.

        for (int i = 0; i < numPoints; i++) { //Populating array with Points.
            sequence[i] = new Point();
        }
    }
    //Formats the points of the polygon and it's area and returns as a string.
    public String toString() {

        String theString = "POLY = [";
        //The last point in sequence is repeated so we don't want to print it hence i<pointNum-1.
        for (int i = 0; i < pointNum - 1; i++) {
            theString += sequence[i].pointToString();
            if (i != pointNum - 2) {
                theString += ", ";
            }
        }
        theString += "]:" + String.format("%5.2f", area());
        return theString;
    }
    //Calculates the area inside of the polygon.
    public double area() {
        double area = 0;
        //"n" form the formula is 1 more than the number of points on the polygon. This is not considered anywhere so we
        // modify the formula to be (n-1) instead of (n-2).
        for (int i = 0; i < (pointNum - 1); i++) {
            area += (sequence[i + 1].getX() + sequence[i].getX()) * (sequence[i + 1].getY() - sequence[i].getY());

        }

        return (0.5 * Math.abs(area));
    }
    //This method compares the polygons passed to it, if the "newPolygon" is larger it will return true else false.
    //This is an override of an abstract method from the interface ComparePolygons
    @Override
    public int compareTo(PlanarShape oldPolygon){

        //Get the areas of the polygons in question.
        double areaOld = oldPolygon.area();
        double areaNew = this.area();
        //This is 0.05% of the area of the old polygon.
        double variation = 0.0005*areaOld;
        //New polygon's area must be between these values to be counted as "equal".
        double upperLimit = areaOld + variation;
        double lowerLimit = areaOld - variation;


        //If new bigger than old.
        if(areaNew>areaOld)
        {
            //If the new area is larger than the old then return true.
            return 1;
        }
        //If they're 'equal' check which is closest to origin.
        //Check this if condition
        else if(areaOld == areaNew || areaNew<=upperLimit && areaNew >= lowerLimit)
        {
            //The new polygon was closest to the origin so return it as the largest.
            if(oldPolygon.originDistance() >= this.originDistance())
            {
                return 1;
            }
            else return 0;

        }
        //If it somehow gets to this condition return false.
        else return 0;
    }
}
