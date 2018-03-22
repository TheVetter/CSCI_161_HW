package lab108;


/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragement 7.7
 * @param <E>
 * @author Andrew Vetter
 * @version 3/21/18
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position.
     * 
     * @return the stored element
     * @thorws IllegalStateExceptoin if position no longer valid
     */
    E getElement( ) throws IllegalStateException;
}
