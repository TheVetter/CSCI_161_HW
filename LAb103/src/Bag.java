/**
 *Interface that defines methods for a doubly link list
 * 
 * @author Andrew Vetter
 * @version 01/30/18
 * @param <E>
 */
public interface Bag<E> {
    
    /***
     * gets the current size of the array
     * @return the size of the populated array 
     */
    int getCurrentSize();
   
    /***
     * 
     * @return true if empty, else false
     */
    boolean isEmpty();
    
    /**
     * returns true if the bag is full
     * @return 
     */
    boolean isFull();
     /***
     * adds a element to the array, returns true if it worked
     * @param item 
     * @return boolean 
     */
    boolean add( E item );
    
    /***
     * removes a random Element from the list and fills the hole 
     * @return the element removed
     */
    E remove( );
    
    /***
     * removes the first instance of the element E.
     * Returns true if successful 
     * @param element 
     * @return  boolean
     */
    boolean remove(E element);
    
     /**
     * clears out the list 
     */
    void clear( );
     /***
     * returns the frequency of the element 
     * @param element
     * @return 
     */
    int getFrequencyOf( E element );
    
    /**
     * A method that checks if an item exists in the bag.
     * @param element
     * @return 
     */
    boolean contains( E element );
    
    /**
     * A toString method that returns a String representation of the contents of the bag
     * @return 
     */
    @Override
    String toString();
    
    /**
     * An equals method that returns true if the contents of the two bags are equal, false otherwise.
     * @param o
     * @return 
     */
    @Override
    boolean equals(Object o);
    
}
