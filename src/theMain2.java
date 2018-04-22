import java.io.*;
import java.util.*;

public class theMain2
{

    public static void main(String[] args) {

        //The list into which values shall be read.
        MyPolygons list = new MyPolygons();
        //Read the values into the list.
        list = reader(list, "data.txt");

        reader(list);

    }
    //Reads and stores file content into a MyPolygons list and returns that list.
    public static MyPolygons reader(MyPolygons theList, String theFile){

        //This is what the text from the file will go in.
        String line;
        //Initilising x and y coords.
        //length for the string
        //counter for the forloop.
        int x,y,length,counter = 0;


        try{
            //Open the file reader.
            FileReader fileReader = new FileReader(theFile);
            //Use that file reader to create a buffered reader. It's superior.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //While the file has contents continue reading in. Each line represent a polygon.

            while((line = bufferedReader.readLine())!=null) {

                //Resetting the counter
                counter = 0;

                //If the character is a P then you had better read in some values my dude.
                if(line.charAt(0) == 'P') {

                    //This is how many points is in the polygon & will always be 1 whitespace away from 'P' to the right.
                    int numberOfPoints = Integer.parseInt(String.valueOf(line.charAt(2)));
                    //Initialising a new polygon. numberOfPoints +1 for extra copy of first point.
                    Polygon newPolygon = new Polygon(numberOfPoints + 1);
                    //This is the length of the string.
                    length = line.length();

                    //Cycle through the polygon extracting point information.
                    for(int i = 4; i<(length);i+=4, counter++) {

                       //Casting characters to integers.
                       x = Integer.parseInt(String.valueOf(line.charAt(i)));
                       y = Integer.parseInt(String.valueOf(line.charAt(i+2)));
                       //System.out.println("This is x: " + x + " and this is y: " + y + ".");
                       newPolygon.getPoint(counter).setPoints(x,y);

                    }

                    //Adding the point populated polygon to the head of the list.
                   theList.add_to_head(newPolygon);
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

    //Prints out the contents of a list as they occur head to tail.
    public static void reader(MyPolygons theList){
        //the list length represents the number of polygons inside.
        int length = theList.getSize();
        //reset the current pointer to sentinel which houses no data so then move forward one space.
        theList.reset();
        theList.forward();
        //Loop for as many polygons that are inside.
        for(int i = 0; i<length;i++){
            System.out.println(theList.getPolygon().polyToString());
            theList.forward();
        }
    }
}
