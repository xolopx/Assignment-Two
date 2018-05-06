import java.io.*;
import java.util.*;

public class PA2
{

    public static void main(String[] args) {
        String theFile = Arrays.toString(args);
        //trim the fat.
        theFile = theFile.substring(1, theFile.length()-1);
        SortedList<PlanarShape> sortedList = new SortedList<PlanarShape>();
        //read in data file.
        sortedList = readerSub(sortedList,theFile);
        //print the list
        printer(sortedList);
    }
    //Reads and stores file content into a LinkedList list and returns that list. Is for returning LinkedList.
    private static LinkedList readerSup(LinkedList<PlanarShape> theList, String theFile){

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
    //This is shapefactory.
    private static SortedList<PlanarShape> readerSub(SortedList<PlanarShape> theList, String theFile) {

        try {
            File dataFile = new File(theFile);
            Scanner theScanner = new Scanner(dataFile);
            //Continue while the file has contents to be read in.
            while (theScanner.hasNext()) {
                switch (theScanner.next()) {
                    //polygon
                    case "P":
                        //read in the length.
                        int length = theScanner.nextInt();
                        int count = 0;
                        double x, y = 0;
                        //create a polygon
                        Polygon theGon = new Polygon(length);

                        //This will populate with points yo'.
                        while (count != length) {
                            //get the pointies.
                            x = theScanner.nextDouble();
                            y = theScanner.nextDouble();
                            //set the point.
                            theGon.getPoint(count).setPoints(x, y);
                            //add the point to the last index position as well.
                            if (count == 0) {
                                theGon.getPoint(length - 1).setPoints(x, y);
                            }
                            count++;

                        }

                        theList.insertInOrder(theGon);
                    break;
                    //circle
                    case "C":
                        //read in the length.
                        double radius = theScanner.nextDouble();
                        x = theScanner.nextDouble();
                        y = theScanner.nextDouble();
                        //Populate the circle with data.
                        Circle theCirc = new Circle(x, y, radius);
                        //Insert the circle into the list.
                        theList.insertInOrder(theCirc);
                    break;
                    //semicircle
                    case "S":
                    double xCoord1,xCoord2,yCoord1,yCoord2;

                    xCoord1 = theScanner.nextDouble();
                    yCoord1 = theScanner.nextDouble();
                    xCoord2 = theScanner.nextDouble();
                    yCoord2 = theScanner.nextDouble();

                    //Populate a semicircle with data.
                    Semicircle theSemi = new Semicircle(xCoord1,yCoord1,xCoord2,yCoord2);
                    //insert the semicircle in the list.
                    theList.insertInOrder(theSemi);
                    break;

                }
            }

        }catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + theFile + "'");
        }
        return theList;
    }
    //Prints out the contents of a list as they occur head to tail.
    private static void printer(LinkedList<PlanarShape> theList){

        //This is the iterator for the list.
        Iterator<PlanarShape> theIterator = theList.iterator();
        //Loop until there is no next new item in the list, using iterator.
        while(theIterator.hasNext()){
            System.out.println(theIterator.next());
        }
        System.out.println("\n\n");
    }

}
