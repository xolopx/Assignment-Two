


//
////Reads data into a MyPolygons list.
//public MyPolygons reader(MyPolygons theList, const char *theFile);
//
////Prints out the contents of a list.
//public void printList(MyPolygons aList);
//
////Takes in an unsorted list and sorts it into a new list.
//MyPolygons sorter(MyPolygons unsortedList, MyPolygons sortedList);


public class theMain2()
{

    public static void main(String[] args){
        //The list into which values shall be read.
        MyPolygons unsortedList = new MyPolygons();
        //Read the values in the list.
        unsortedList = reader(unsortedList,"data.txt");


        //Print out the unsorted list.
        System.println("The Unsorted List");
        printList(unsortedList);

        //New list to sort items into.
        MyPolygons sortedList = new MyPolygons();
        //Sort the bad boy.
        sortedList = sorter(unsortedList,sortedList);

        printList(sortedList);

        return 0;
    }

}

MyPolygons reader (MyPolygons theList, const char* theFile)
{
    //create a placeholder string for read in characters.
    String character;
    /*
        //create a stream to the data file.
        std::ifstream fileStream;
        //This is the number of polygons.
        int numPoints = 0;
        //Alias of size_t... whatever the heck that means.
        std::string::size_type size;
        //The variables into which the points will be stored.
        double x,y = 0;
        //open the stream.
        fileStream.open(theFile);

        //While the file is not empty.
        while(!fileStream.eof())
        {
        //Put the characters into the string. The for-loop will cycle through the data.
        fileStream >> character;

        //Check if the character read in was a "P".
        if(character == "P")
        {
        //The next character is always the number of points in the polygon.
        fileStream >> character;
        //cast the string "character" to integer.
        numPoints = std::stoi(character,&size);
        //Create a new polygon to pop all your data in. The file has just announced a new polygon. Add extra
        // index so that we can store the first point in the last point.
        polygon* aPolygon = new polygon(numPoints+1);
        //now read in the rest of the information for that polygon which will be the point coordinates.
        for(int i = 0; i< numPoints; i++)
        {
        //read in the x coordinate.
        fileStream>>character;
        //cast the string to a double.
        x = std::stod(character,&size);
        //read in the y coordinate.
        fileStream>>character;
        //cast the string to a double.
        y = std::stod(character,&size);
        //now we store the coordinates in a point in the new polygon.
        aPolygon->getPoint(i)->setPoints(x,y);
        }

        //Store the first point in last index for printing calculation of area.
        x = aPolygon->getPoint(0)->getX();
        y = aPolygon->getPoint(0)->getY();
        //Set the final point.
        aPolygon->getPoint(numPoints)->setPoints(x,y);
        //store the polygon in the list.
        theList->add_to_head(*aPolygon);
        }
        }//end while loop.
    */

    return theList;
}

public void printList(MyPolygons aList){
    //Current to sentinel.
    aList.reset();
    //Current to head.
    aList->forward();
    for(int i = 0; i<aList.getSize();i++) {

        std::cout << aList->getNode().get_data()->polyToString() << std::endl;
        aList->forward();
    }
    std::cout<<std::endl<<std::endl;
}

MyPolygons<polygon>* sorter(MyPolygons<polygon>* unsortedList, MyPolygons<polygon>* sortedList)
{

//Start by setting the current largest to the head of the unsorted list.
//  NB: getHead will reset the current ptr to head.
polygon currentLargest = *unsortedList->getHead().get_data();
//we set to current largest by default for cheekyCounter to work.
polygon challengerPolygon = currentLargest;
//This counter determines which node was largest and then removes it from the unsortedList.
int cheekyCounter = 1;
//Tracks the position of the latest largest.
int thePosition = 0;
//Need the list length to know how many times to compare.
int listLength = unsortedList->getSize();



while(listLength!=0)
{

//Restarting process. getHead resets the current.
currentLargest = *unsortedList->getHead().get_data();
challengerPolygon = currentLargest;


//length - 1 as we are in position one when we enter the for loop.
for (int i = 0; i < unsortedList->getSize(); i++)
{
//If this is true the challenger is larger.
if (currentLargest.compare(challengerPolygon))
{
//We should get in here at least once.
currentLargest = challengerPolygon;
//We know that the position of the latest largest is at cheekyCounter.
thePosition = cheekyCounter;
}
//continue through the list.
unsortedList->forward();
cheekyCounter++;
//Get the next polygon.
challengerPolygon = *unsortedList->getNode().get_data();
}


//Removal and insertion of largest.
sortedList->add(currentLargest);
//Reset current to sentinel.
unsortedList->reset();


//Cycle through the list until we find the node we are looking for.
for (int i = 0; i < thePosition; i++)
{
//Move current forward to the largest node.
unsortedList->forward();
}
//removes the node at current. Reduces the length of the list.
unsortedList->remove();




//Reset. SHOULD BE ONE.
cheekyCounter = 1;
//Reset
thePosition = 0;
//Update
listLength = unsortedList->getSize();
//Reset
sortedList->reset();
//Reset
unsortedList->reset();
}

return sortedList;
}
