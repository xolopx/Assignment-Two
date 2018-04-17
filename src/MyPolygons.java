/**
 * Created by tom on 16/04/2018.
 */
public class MyPolygons {

    private Node head_ptr_ = new Node();
    private Node tail_ptr_ = new Node();
    private Node current_ptr_ = new Node();
    private Node sentinel = new Node();
    private int list_length = 0;

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

    public void add_to_head(Polygon data) {
        //return current to sentinel.
        reset();
        add(data);
    }


    public void add_to_tail(Polygon data) {
        //Set current to the previous of the sentinel (aka the tail).
        current_ptr_ = sentinel.get_previous();
        //pop that badboi in the list yo.
        add(data);
    }


    public Node getNode()
        {
            return current_ptr_;
        }


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
        sentinel.set_next(freshNode);
        //set current to the new node.
        current_ptr_= freshNode;
        //increment the ol' listo.
        list_length++;

    }


    public void forward() {
    current_ptr_ = current_ptr_.get_next();
}


    public void back() {
    current_ptr_ = current_ptr_.get_previous();
}


    public void reset() {
    current_ptr_= sentinel;
}


    public void insert(int position, Polygon data)
    {
        //reset the position of the current pointer to have a starting point.
        reset();
        //cycle through the linked list until the position is reached.
        for(int i = 0;i<position;i++)
        {
            //will cycle the current pointer forward to the position.
            forward();
        }
        //Position is now reached so add the new node.
        add(data);
    }


    public Node pop()
    {
        //Create a pointer to store the retrieved head in.
        Node theHead;
        //retrieve the head.
        theHead = getHead();
        //delete the head.
        deleteHead();

        return theHead;
    }


    public Node getHead()
    {
        //make the current the next of the sentinel (aka the head).
        current_ptr_ = sentinel.get_next();

        //return the node stored at the current, spoiler it's the head.
        return getNode();

    }


    void deleteHead()
    {
        //set the current to the sentinel.
        reset();
        //Set the current to the head.
        forward();
        //remove that badboi.
        remove();

    }

    int getSize() {
    return list_length;
}

    void remove() {

    Node pointToOld = current_ptr_;

    //Set the heads previous' next to the heads next. So splice out the previous' life.
    current_ptr_.get_previous().set_next(current_ptr_.get_next());
    //Set the head's next to it's previous. So splice it out of the next's life.
    current_ptr_.get_next().set_previous(current_ptr_.get_previous());
    //Make the next node the current.
    forward();
    //decrement length.
    list_length--;



    }


}
