/**
 * Created by tom on 23/04/2018.
 * This class extends MyPolygons and adds the functionality to sort a MyPolygons list.
 * "extends" = "inherits"
 * SortedPolygons has all of the functionality of MyPolygons plus some more that I am going to add.
 * This class is the same as MyPolygons however it has additional functionality.
 */
public class SortedPolygons extends MyPolygons implements ComparePolygons {

    //This function sorts Polygons that are passed to it using the insertion sort method and implementing the
    //ComparePolygons interface.
    public void insertSort(Polygon newPolygon){

    }
    //This method compares the polygons passed to it, if the "newPolygon" is larger it will return true else false.
    //This is an override of an abstract method from the interface ComparePolygons
    public boolean comparePoly(Polygon newPolygon, Polygon oldPolygon){

        //Get the areas of the polygons in question.
        double areaOld = oldPolygon.calcArea();
        double areaNew = newPolygon.calcArea();
        //This is 0.05% of the area of the old polygon.
        double variation = 0.0005*areaOld;
        //New polygon's area must be between these values to be counted as "equal".
        double upperLimit = areaOld + variation;
        double lowerLimit = areaOld - variation;


        //If new bigger than old.
        if(areaNew>areaOld)
        {
            //If the new area is larger than the old then return true.
            return true;
        }
        //If they're 'equal' check which is closest to origin.
        else if(areaOld == areaNew || areaNew<=upperLimit && areaOld >= lowerLimit)
        {
            //The new polygon was closest to the origin so return it as the largest.
            if(oldPolygon.closestOrigin() >= newPolygon.closestOrigin())
            {
                return true;
            }
            else return false;

        }
        //If it somehow gets to this condition return false.
        else return false;
    }
}




