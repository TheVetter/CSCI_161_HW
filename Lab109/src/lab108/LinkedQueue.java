package lab108;


/** Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 * @param <E>
 * @author Andrew Vetter
 * @version 3/21/18
 */
public class LinkedQueue<E> implements Queue<E> {

    private final SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list
    public LinkedQueue( ) { }
    // new queue relies on the initially empty list
    @Override
    public int size( ) { return list.size( ); }
    @Override
    public boolean isEmpty( ) { return list.isEmpty( ); }
    @Override
    public void enqueue(E element) { list.addLast(element); }
    @Override
    public E first( ) { return list.first( ); }
    @Override
    public E dequeue( ) { return list.removeFirst( ); }
    public String elementsToString(){
        return list.toString();
    }
}