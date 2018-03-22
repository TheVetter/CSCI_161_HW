package lab108;

/**An interface for a binary tree, in which each node has at most two children.
 *
 * @author Andrew Vetter
 * @version 3/8/18
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E> {
    
    /** Returns the Position of p's left child (or null if no child exists).
     * @param p
     * @return 
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    /** Returns the Position of p's right child (or null if no child exists).
     * @param p
     * @return 
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    
    /** Returns the Position of p's sibling (or null if no sibling exists).
     * @param p
     * @return 
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
