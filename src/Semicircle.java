/**
 * Created by tom on 5/05/2018.
 */
public class Semicircle extends PlanarShape {

    private double radius = 0;

    Semicircle(double xCoord1, double yCoord1, double xCoord2, double yCoord2,double radii){

        sequence = new Point[2];

        sequence[0].setPoints(xCoord1,yCoord1);
        sequence[1].setPoints(xCoord2,yCoord2);

        radius = radii;

    }
    public double area(){

        return (Math.PI*Math.pow(radius,2))/2;
    }

    public String toString(){
        String theString = "SEMI:["+sequence[0].pointToString()+", ";
                theString +=sequence[1].pointToString()+"]:"+area();

        return theString;
    }
}
