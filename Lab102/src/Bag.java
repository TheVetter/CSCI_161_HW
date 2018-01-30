/**
 *
 * @author vetter
 */
public interface Bag {
    
    int getCurrentSize();
   
    boolean isEmpty();
    
    void add( int num );
    
    void remove( );
    
    void remove(int num);
    
    void clear( );
    
    int getFrequencyOf( int num );
    
    boolean contains( int num );
    
    String toString();
    
    boolean equals(Object o);
    
}
