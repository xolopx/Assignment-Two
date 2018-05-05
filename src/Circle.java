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
    Circle(double xCoord, double yCoord, double radii) {
        pointNum = 1;
        //set the radius.
        radius = radii;
        sequence = new Point[1];
        //set the center point.
        sequence[0] = new Point();
        sequence[0].setPoints(xCoord,yCoord);


    }

    //Formats the points of the polygon and it's area and returns as a string.
    public String toString() {

        //Circle string is rather simpler.
        String theString = "CIRC = ["+ sequence[0].pointToString()+", "+radius;
        theString += "]:" + String.format("%5.2f", area());
        return theString;
    }

    //Calculates the area inside of the polygon.
    public double area() {
        return (Math.PI*Math.pow(radius,2));
    }

    //Overriding the PlanarShapes origin Distance
    @Override
    //Returns the distance of the point closest to the origin. For some reason.
    public double originDistance() {
        //initialize the distance to one of the points.
        double distance = sequence[0].distOrigin();
        for (int i = 0; i < pointNum; i++) {
            if (distance > sequence[i].distOrigin()) {
                distance = sequence[i].distOrigin();
            }
        }

        return distance-radius;
    }
}


