/**
 * Created by tom on 29/04/2018.
 */
public abstract class PlanarShape implements Comparable<PlanarShape>{

    protected int pointNum;           //This is the number of points in the polygon
    protected Point[] sequence;      //This is the array of points in the polygon

    //DO NEED to be overridden.

    public abstract String toString();
    public abstract double area();


    //DON'T NEED to be overridden.

    //Returns the distance of the point closest to the origin. For some reason.
    public double originDistance() {
        //initialize the distance to one of the points.
        double distance = sequence[0].distOrigin();
        for (int i = 0; i < pointNum; i++) {
            if (distance > sequence[i].distOrigin()) {
                distance = sequence[i].distOrigin();
            }
        }

        return distance;
    }
    //Will return a point in a location in sequence array. It will return a pointer to a point.
    public Point getPoint(int index) {
        return sequence[index];
    }
    //This method compares the polygons passed to it, if the "newPolygon" is larger it will return true else false.
    //This is an override of an abstract method from the interface ComparePolygons
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
