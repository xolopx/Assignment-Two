import java.io.*;
import java.util.*;

public class theMain2
{

    public static void main(String[] args) {

        //The list into which values shall be read.
        MyPolygons unsortedList = new MyPolygons();
        //Read the values into the list.
        //You can do this as sortedPolygons is a type of MyPolygons.
        SortedPolygons sortedList = new SortedPolygons();

        //Read in.
        unsortedList = readerSup(unsortedList, "data.txt");
        sortedList = readerSub(sortedList,"data.txt");

        System.out.println("Unsorted list: \n");
        printer(unsortedList);
        System.out.println("\n\n");

//        Polygon paul = new Polygon (3);
//        unsortedList.insert(2,paul);
//        printer(unsortedList);


        sortedList.sort();

        System.out.println("Sorted list: \n");
        printer(sortedList);
        System.out.println("\n\n");


    }
    //Reads and stores file content into a MyPolygons list and returns that list. Is for returning MyPolygons.
    public static MyPolygons readerSup(MyPolygons theList, String theFile){

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

    //Reads and stores file content into a MyPolygons list and returns that list. Is for returning SortedPolygons.
    public static SortedPolygons readerSub(SortedPolygons theList, String theFile){

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
    public static void printer(MyPolygons theList){
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

    //Copies the unsorted list into the sorted one. Copies listA into listB.
    public static SortedPolygons copyList(MyPolygons listA, SortedPolygons listB){

        //This is the number of polygons in listA.
        int lengthA = listA.getSize();



        return listB;
    }
}
