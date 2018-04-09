/**
 * Created by tom on 9/04/2018.
 */

import java.lang.Math;

public class Point {

    private double x;
    private double y;

    //Default constructor.
    Point()
    {
        x = 0;
        y = 0;
    }
    //set's the values for the point coordinates.
    public void setPoints(double xCoord, double yCoord)
    {
        x = xCoord;
        y = yCoord;
    }
    //return the points as a string of format 4.2f (That is 4 spaces dedicated with 2 decimal places).
    public String pointToString()
    {
        //initialize the string that will go in.
        String theString = "(";

        theString += Double.toString(x);    //Casting to a String
        theString += ",";
        theString += Double.toString(y);    //Casting to a String
        theString += ")";

        return theString;
    }
    //Sets the x-coordinate of point.
    void setX(double xCoord)
    {
        x = xCoord;
    }
    //Sets the y-coordinate of point.
    void setY(double yCoord)
    {
        y = yCoord;
    }
    //Returns the distance of the point from the origin.
    double distOrigin()
    {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }
    //returns the x-coordinate of the point.
    double getX()
    {
        return x;
    }
    //returns the y-coordinate of the point.
    double getY()
    {
        return y;
    }
}
