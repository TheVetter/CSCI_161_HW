

/**The Singly Linked list class. A Generic Singley linked list 
 *
 * @author Andrew Vetter
 * @version 02/18/18
 */
public class SinglyLinkedList<E> {
    
    
//---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;
        // reference to the element stored at this node

        private Node<E> next;
        // reference to the subsequent node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getNext( ) { return next; }
        public void setNext(Node<E> n) { next = n; }

    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;
    // head node of the list (or null if empty)
    private Node<E> tail = null;
    // last node of the list (or null if empty)

    private int size = 0;
    // number of nodes in the list

    // constructs an initially empty list
    public SinglyLinkedList( ) { }

    /**
     * returns the size of the list
     * @return 
     */
    public int size( ) { return size; }

    /**
     * determines if the list is empty
     * @return 
     */
    public boolean isEmpty( ) { return size == 0; } 

    /**
     * look at the first element of the list 
     * @return the generic element of the list 
     */
    public E first( ) {
        // returns (but does not remove) the first element
        if (isEmpty( )) return null;
        return head.getElement( );
    }

    /**
     * 
     * @return the last element in the list with out removing it 
     */
    public E last( ) {
        // returns (but does not remove) the last element
        if (isEmpty( )) return null;
        return tail.getElement( );
    }

    /**
     * add an element to the beginning of the list 
     * @param e 
     */
    public void addFirst(E e) {
        // adds element e to the front of the list
        head = new Node<>(e, head);
        // create and link a new node
        if (size == 0)
            tail = head;
        // special case: new node becomes tail also
        size++;
    }

    /**
     * add an element to the end of the list
     * @param e 
     */
    public void addLast(E e) {
        // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty( ))
            head = newest;
        // special case: previously empty list
        else
            tail.setNext(newest);

        // new node after existing tail
        tail = newest;
        // new node becomes the tail
        size++;
    }
    
    /**
     * remove the first element of the list and return it 
     * @return 
     */
    public E removeFirst( ) {
    // removes and returns the first element
        if (isEmpty( )) return null;
        // nothing to remove
        E answer = head.getElement( );
        head = head.getNext( );

        // will become null if list had only one node
        size--;

        if (size == 0)
            tail = null;
        // special case as list is now empty
        return answer;

    }
    
    /**
     * 
     * @return a formatted string regarding the current instance of the class
     */
    @Override
    public String toString(){
        String result = getClass().getName() + " @ Size:" + size;
        
        for(int i =0; i<size; i++){
            E temp = removeFirst();
            result += " : " + temp;
            addLast(temp);
        }
        
        return  result;
    }
    
}