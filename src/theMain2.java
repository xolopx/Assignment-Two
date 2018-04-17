import java.io.*;

public class theMain2
{

    public static void main(String[] args){

        //The list into which values shall be read.
        MyPolygons unsortedList = new MyPolygons();
        //Read the values in the list.
        unsortedList = reader(unsortedList,"data.txt");


        //Print out the unsorted list.
        //System.out.println("The Unsorted List");
        // printList(unsortedList);

        //New list to sort items into.
        MyPolygons sortedList = new MyPolygons();
        //Sort the bad boy.
        //sortedList = sorter(unsortedList,sortedList);

        //printList(sortedList);
    }

    //Reads in the data from the file.
    public static MyPolygons reader (MyPolygons theList, String theFile){
        try{
            //create a placeholder string for read in characters.
            int value = 0;
            //string placeholder for data
            String line = null;
            //for creating an array to store values in
            int arrayLength = 0;
            //Opening the fileStream.
            FileReader fileReader=new FileReader(theFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            //Print out each character. read() returns the ascii value of characters.
            while((line = bufferedReader.readLine())!=null){

                //returns the length of line.
                arrayLength = line.length();
            }
            bufferedReader.close();
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
