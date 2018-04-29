import java.io.*;
import java.util.*;

public class theMain2
{

    public static void main(String[] args) {

        //Create an empty list.
        SortedList<PlanarShape> sortedList = new SortedList();

        //read in data file.
        sortedList = readerSub(sortedList,"data.txt");
        //print the list
        printer(sortedList);
        //create a polygon to add.
        Polygon paul = new Polygon(4);
        //Insert sort the bastard.
        sortedList.insertInOrder(paul);
        //print again .
        printer((sortedList));




    }
    //Reads and stores file content into a LinkedList list and returns that list. Is for returning LinkedList.
    public static LinkedList readerSup(LinkedList<PlanarShape> theList, String theFile){

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
                    //Sets the last point to also be the first point.
                    newPolygon.getPoint(numberOfPoints).setPoints(newPolygon.getPoint(0).getX(),newPolygon.getPoint(0).getY());
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

    //Reads and stores file content into a LinkedList list and returns that list. Is for returning SortedList.
    public static SortedList readerSub(SortedList<PlanarShape> theList, String theFile){

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
                    //Sets the last point to also be the first point.
                    newPolygon.getPoint(numberOfPoints).setPoints(newPolygon.getPoint(0).getX(),newPolygon.getPoint(0).getY());
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
    public static void printer(LinkedList theList){
        //the list length represents the number of polygons inside.
        int length = theList.getSize();
        //reset the current pointer to sentinel which houses no data so then move forward one space.
        theList.reset();
        theList.forward();
        //Loop for as many polygons that are inside.
        for(int i = 0; i<length;i++){
            System.out.println(theList.getObject().toString());
            theList.forward();
        }
        System.out.println("\n\n");
    }

}
