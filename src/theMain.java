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

       System.out.println(bob.polyToString());

    }
}
