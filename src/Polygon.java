/**
 * Created by tom on 9/04/2018.
 */
import java.lang.Math;

public class Polygon {

    private int pointNum;           //This is the number of points in the polygon
    private Point[] sequence;      //This is the array of points in the polygon

    //constructor. The polygon MUST be given a size.
    Polygon(int numPoints)
    {
        pointNum = numPoints;           //assigning number of points
        sequence = new Point[pointNum]; //initializing the already declared array of points.

        for (int i = 0; i < numPoints; i++){ //Populating array with Points.
            sequence[i] = new Point();
        }
    }

    //Will return a point in a location in sequence array. It will return a pointer to a point.
    public Point getPoint(int index)
    {
        return sequence[index];
    }

    //Formats the points of the polygon and it's area and returns as a string.
    public String polyToString()
    {

        String theString ="";

        return theString;
    }

    //Calculates the area inside of the polygon.
    public double calcArea()
    {
        double area = 0;
        double interimResult = 0;
        //"n" form the formula is 1 more than the number of points on the polygon. This is not considered anywhere so we
        // modify the formula to be (n-1) instead of (n-2).
        for (int i = 0; i < (pointNum); i++)
        {
            interimResult = (sequence[i+1].getX()+sequence[i].getX())*(sequence[i+1].getY()-sequence[i].getY());
            area += interimResult;
        }

        return (0.5*Math.abs(area));
    }

    //Returns the distance of the point closest to the origin. For some reason.
    public double closestOrigin()
    {
        //initialize the distance to one of the points.
        double distance = sequence[0].distOrigin();
        for(int i = 0; i<pointNum;i++)
        {
            if(distance>sequence[i].distOrigin())
            {
                distance = sequence[i].distOrigin();
            }
        }

        return distance;
    }



}
