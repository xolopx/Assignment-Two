/**
 * Created by tom on 23/04/2018.
 * This interface provides the abstract methods required to compare polygons. Its methods must be abstract and be
 * defined by the first concrete subclass to inherit the interface.
 */
public interface ComparePolygons {

    //This method will return true if the "newPolygon" passed to it is larger than the "oldPolygon" else return false.
    public abstract boolean comparePoly(Polygon newPolygon, Polygon oldPolygon);
}
