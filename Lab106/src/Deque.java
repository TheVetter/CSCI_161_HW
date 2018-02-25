/**
* Interface for a double-ended queue: a collection of elements that can be inserted
* and removed at both ends; this interface is a simplified version of java.util.Deque.
* @author Andrew Vetter
* @version 02/22/2018
* @param <E>
*/
public interface Deque<E> {
    
    /** Returns the number of elements in the deque.
    * @return Size of deque  
    */
    int size( );

    /** Tests whether the deque is empty.
    * @return  boolean of state of deque
    */
    boolean isEmpty( );

    /** Returns, but does not remove, the first element of the deque (null if empty).
     * @return the first element
     */
    E first( );


    /** Returns, but does not remove, the last element of the deque (null if empty).
    * @return  the last element
    */
    E last( );

    /** Inserts an element at the front of the deque.
    * @param e 
    */
    void addFirst(E e);

    /** Inserts an element at the back of the deque.
    * @param e 
    */
    void addLast(E e);

    /** Removes and returns the first element of the deque (null if empty).
    * @return  the first element
    */
    E removeFirst( );

    /** Removes and returns the last element of the deque (null if empty).
    * @return the last element
    */
    E removeLast( );
    
}