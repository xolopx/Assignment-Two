import java.io.*;
import java.util.*;

public class theMain2
{

    public static void main(String[] args) {

        //The list into which values shall be read.
        MyPolygons list = new MyPolygons();
        //Read the values into the list.
        list = reader(list, "data.txt");

        //Cycles through list extracting polygons.
        for(int i = 0;i<list.getSize()-1;i++){

            System.out.println("Polygon Number: "+(i+1)+"\n" + list.getPolygon().polyToString()+"\n\n");
            //increment the current pointer of the list.
            list.forward();
        }


    }
    //Reads and stores file content into a MyPolygons list and returns that list.
    public static MyPolygons reader(MyPolygons theList, String theFile){

        //This is what the text from the file will go in.
        String line;
        //Initilising x and y coords.
        int x,y = 0;
        //The length of the string to be read into.
        int length = 0;
        //Counter used for populating polygon.
        int counter = 0;

        try{
            //Open the file reader.
            FileReader fileReader = new FileReader(theFile);
            //Use that file reader to create a buffered reader. It's superior.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //While the file has contents continue reading in. Each line represent a polygon.
            while((line = bufferedReader.readLine())!=null) {
                //Resetting the counter
                counter = 0;

                    System.out.println("Polygon details: " + line);
                //If the character is a P then you had better read in some values my dude.
                if(line.charAt(0) == 'P') {
                    //This is how many points is in the polygon & will always be 1 whitespace away from 'P' to the right.
                   int numberOfPoints = Integer.parseInt(String.valueOf(line.charAt(2)));
                      //  System.out.println("No. points in the polygon: " + numberOfPoints);

                    //Initialising a new polygon. We add one to the end as it needs to have first point as the last
                    // point as well.
                    Polygon newPolygon = new Polygon(numberOfPoints + 1);

                    //This is the length of the string.
                   length = line.length();
                       // System.out.println("This is the length of the string: " + length);
                   //Cycle through the polygon extracting point information.
                   for(int i = 4; i<(length);i+=4, counter++) {
                       //Casting characters to integers.
                       x = Integer.parseInt(String.valueOf(line.charAt(i)));
                       y = Integer.parseInt(String.valueOf(line.charAt(i+2)));
                       //System.out.println("This is x: " + x + " and this is y: " + y + ".");
                       newPolygon.getPoint(counter);
                   }
                   //Adding the point populated polygon to the list.
                   theList.add(newPolygon);
                }
            }
            fileReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + theFile + "'");
        }
        catch(IOException ex){
            System.out.println("Error reading file '"+theFile+"'");
        }

        return theList;
    }

}
