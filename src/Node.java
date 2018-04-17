//THOMAS COURTNEY: 3175353
public class Node{

    private Polygon data = null;
    private Node next = null;
    private Node previous = null;

	Node() {
    	data = null;
    	next = null;
    	previous = null;
        }

    Node(Polygon init_data) {
        data = init_data;
        next = null;//init_next;
        previous = null; //init_previous;
        }

    public void set_data( Polygon new_data) 			{data = new_data;}

    public void set_next(Node next_link) 			    {next = next_link;}

    public void set_previous(Node previous_link) 	    {previous = previous_link;}

    public Polygon get_data() 							{return data;}

    public Node get_previous() 			                {return previous;}

    public Node get_next()							    {return next;}

}