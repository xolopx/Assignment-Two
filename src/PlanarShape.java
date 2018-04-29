/**
 * Created by tom on 29/04/2018.
 */
public abstract class PlanarShape implements Comparable<PlanarShape>{

    public abstract String toString();
    public abstract double area();
    public abstract double originDistance();
    public abstract int compareTo(PlanarShape object);

}
