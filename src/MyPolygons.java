/**
 * Created by tom on 16/04/2018.
 */
public class MyPolygons {

    //"protected" maintains encapsulation but allows subclasses access to member variables.
    protected Node head_ptr_ = new Node();
    protected Node tail_ptr_ = new Node();
    protected Node current_ptr_ = new Node();
    protected Node sentinel = new Node();
    protected int list_length = 0;

    MyPolygons() {

        //All signs point to sentinel.
        head_ptr_ = sentinel;
        tail_ptr_ = sentinel;
        //Tell that sentinel where to go.
        sentinel.set_next(head_ptr_);
        sentinel.set_previous(tail_ptr_);
        //currently we are pointed at the sentinel as current because it's the only goddamn node.
        current_ptr_ = sentinel;
        //We will call the list length zero because the sentinel has no data in it.
        list_length = 0;
    }

    //Returns polygon at current. Does NOT return a node.
    public Polygon getPolygon()
    {
        //This returns the polygon in the current node.
        return current_ptr_.get_data();
    }
    //This adds a new node and piece of data to the head of the list. Uses add() method.
    public void add_to_head(Polygon data) {
        //return current to sentinel.
        reset();
        add(data);
    }

    //This adds a new node and piece of data to the tail of the list. uses add() method.
    public void add_to_tail(Polygon data) {
        //Set current to the previous to sentinel. Point to sentinel as add() pushed the list down.
        current_ptr_ = sentinel;
        //pop that badboi in the list yo.
        add(data);
    }

    //This is a generic method used for both add to head and tail. It creates a new node and places the data in it then
    //places the node in a position that is dictated by where current_ptr_ points.
    public void add(Polygon data)
    {
        //1. create new node on heap
        Node freshNode = new Node(data);
        //set the next pointer of new node to the next of the sentinel.
        freshNode.set_next(current_ptr_.get_next());
        //set the previous node of the new node to the sentinel. It is now positioned where the head would be. Good.
        freshNode.set_previous(current_ptr_);
        //Set the sentinels next's previous to be the new Node.
        current_ptr_.get_next().set_previous(freshNode);
        //Set the sentinel's next to be the new node.
        current_ptr_.set_next(freshNode);
        //set current to the new node.
        current_ptr_= freshNode;
        //increment the ol' listo.
        list_length++;

//        //inserts polygon before location of current.
//        Node newNode = new Node(data);
//        newNode.prev().next(newNode);
//        newNode.next().prev(newNode);
//        length++;

    }

    //Moves the current ptr forward.
    public void forward() {
    current_ptr_ = current_ptr_.get_next();
}

    //Moves the current ptr back.
    public void back() {
    current_ptr_ = current_ptr_.get_previous();
}

    //Resets the current pointer to the sentinel.
    public void reset() {
    current_ptr_= sentinel;
}

    //inserts a node after position given.
    public void insert(int position, Polygon data)
    {
        //reset the position of the current pointer to have a starting point.
        reset();
        //cycle through the linked list until the position is reached.
        for(int i = 1;i<position;i++)
        {
            //will cycle the current pointer forward to the position.
            forward();
        }
        //Position is now reached so add the new node.
        add(data);
    }

    //Takes the head off the list and returns the data inside it.
    public Polygon pop()
    {
        //make the current the next of the sentinel (aka the head).
        current_ptr_ = sentinel.get_next();
        //Create a pointer to store the retrieved head in.
        Node theHead;
        //retrieve the head.
        theHead = current_ptr_;
        //delete the head.
        deleteHead();

        return theHead.get_data();
    }


    //Simply removes the head of the list.
    public void deleteHead()
    {
        //set the current to the sentinel.
        reset();
        //Set the current to the head.
        forward();
        //remove that badboi.
        remove();

    }
    //Returns the size of the list.
    public int getSize() {
    return list_length;
}

    //Removes the node at the current ptr.
    public void remove() {

    //Set the heads previous' next to the heads next. So splice out the previous' life.
    current_ptr_.get_previous().set_next(current_ptr_.get_next());
    //Set the head's next to it's previous. So splice it out of the next's life.
    current_ptr_.get_next().set_previous(current_ptr_.get_previous());
    //Make the next node the current.
    forward();
    //decrement length.
    list_length--;
    }

    //Returns the data stored in the head node.
    public Polygon getHead() {
        //This is the head polygon.
        Polygon theHead = sentinel.get_next().get_data();

        return theHead;
        //Sure thing babe.
    }

    //Returns the data stored in the tail node.
    public Polygon getTail(){
        //This is the tail polygon.
        Polygon theTail = sentinel.get_previous().get_data();

        return theTail;

    }

}
