/**
 * Created by tom on 5/05/2018.
 */
public class Semicircle extends PlanarShape {

    private double radius = 0;
    //This is the gradient of the line made by the two points given in the data file.
    private double gradient1 = 0;
    //This is the gradient of the line perpendicular to gradient1, that of the two extremity points.
    private double gradient2 = 0;
    //These are the extremity points.
    private Point ex1 = new Point();
    private Point ex2 = new Point();

    Semicircle(double xCoord1, double yCoord1, double xCoord2, double yCoord2){
        //initialize sequence of points.
        sequence = new Point[2];
        //initialize the points in the array.
        sequence[0] = new Point();
        sequence[1] = new Point();
        //populate point sequence with data.
        sequence[0].setPoints(xCoord1,yCoord1);
        sequence[1].setPoints(xCoord2,yCoord2);
        //calculate the radius.
        radius = calcRadius(xCoord1, yCoord1, xCoord2,yCoord2);
        //Calculate the gradients of the two perpendicular lines.
        calcGradients();
        //calculate the extremity points.
        calcExtremes();
    }
    //calculates the area of a semicircle given its radius.
    public double area(){

        return (Math.PI*Math.pow(radius,2))/2;
    }
    //converts the semicircle data to a string.
    public String toString(){
        String theString = "SEMI = ["+sequence[0].pointToString()+", ";
        theString +=sequence[1].pointToString()+"]:"+area();

        return theString;
    }
    //calculates the radius of the semicircle.
    private double calcRadius(double xCoord1, double yCoord1, double xCoord2, double yCoord2){
        radius = Math.abs(Math.sqrt(Math.pow(xCoord2-xCoord1,2)+Math.pow(yCoord2-yCoord1,2)));
        return radius;
    }
    //This calculates the gradient of the two points given in the data file (aka gradient1) and the gradient perpendicular
    //to that one (aka gradient2).
    private void calcGradients(){
        //(x2-x1)/(x2-x1)
        gradient1 = (sequence[1].getX()-sequence[0].getX())/(sequence[1].getY()-sequence[0].getY());
        gradient2 = -1*gradient1;
    }
    //Calculate the extremity points using the data available.
    private void calcExtremes(){
        double x1X,x1Y,x2X,x2Y = 0;
        double k = kFunction();
        x1X = sequence[0].getX() - k;
        x1Y = sequence[0].getY() + k;
        x2X = sequence[1].getX() + k;
        x2Y = sequence[1].getY() - k;

        ex1.setPoints(x1X,x1Y);
        ex2.setPoints(x2X,x2Y);
    }
    //calculates a constant that is used to find the extremities.
    private double kFunction(){return radius/(Math.sqrt(1+Math.pow(gradient2,2)));}
    //Overriding the PlanarShapes origin Distance
    @Override
    //Returns the distance of the point closest to the origin. For some reason.
    public double originDistance() {
        //initialize the distance to one of the points.
        double distance = sequence[0].distOrigin();
        //distance of extremity points.
        double distanceEx1 = ex1.distOrigin();
        double distanceEx2 = ex2.distOrigin();
        for (int i = 0; i < pointNum; i++) {
            if (distance > sequence[i].distOrigin()) {
                distance = sequence[i].distOrigin();
            }
        }
        //if extremity points arte closer to origin set them as the closest point to origin.
        if (distanceEx1<distance){distance = distanceEx1;}
        if (distanceEx2<distance){distance = distanceEx2;}


        return distance;
    }
}
