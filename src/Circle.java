/**
 * Created by tom on 30/04/2018.
 */

    /**
     * Created by tom on 9/04/2018.
     */
import java.lang.Math;

public class Circle extends PlanarShape{

    private double radius = 0;

    //constructor. The polygon MUST be given a size.
    Circle(int numPoints, double radii) {
        pointNum = numPoints;           //assigning number of points
        sequence = new Point[pointNum]; //initializing the already declared array of points.

        for (int i = 0; i < numPoints; i++) { //Populating array with Points.
            sequence[i] = new Point();
        }
    }

    //Formats the points of the polygon and it's area and returns as a string.
    public String toString() {

        String theString = "CIRC = [";
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

        double radius = Math.sqrt(Math.pow(sequence[0].getX()-sequence[1].getX(),2)+Math.pow(sequence[0].getX()-sequence[1].getX(),2));

        return (Math.PI*Math.pow(radius,2));
    }


}


