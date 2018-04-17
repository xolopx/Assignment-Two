/**
 * Created by Tom on 08-Apr-18.
 /**
 * Created by Tom on 19-Jan-18.
 */
public class theMain {

    public static void main(String[] args) {

        Polygon bob = new Polygon(4);

        bob.getPoint(0).setPoints(1,1);
        bob.getPoint(1).setPoints(1,2);
        bob.getPoint(2).setPoints(2,1);
        bob.getPoint(3).setPoints(1,1);

        Polygon jordan = new Polygon(5);

        jordan.getPoint(0).setPoints(1,1);
        jordan.getPoint(1).setPoints(1,2);
        jordan.getPoint(2).setPoints(2,2);
        jordan.getPoint(3).setPoints(2,1);
        jordan.getPoint(4).setPoints(1,1);

       if(!bob.comparePolygons(jordan)) {
           System.out.println("Jordan is bigger: " + jordan.polyToString());
       }
       else
       {
           System.out.println("Bob is bigger: " + bob.polyToString());
       }

    }
}
