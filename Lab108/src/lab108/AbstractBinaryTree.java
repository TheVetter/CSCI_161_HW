package lab108;

import java.util.ArrayList;
import java.util.List;

/**An abstract base class providing some functionality of the BinaryTree interface
 *
 * @author Andrew Vetter
 * @version 3/8/18
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
    
    implements BinaryTree<E> {
    
    /** Returns the Position of p's sibling (or null if no sibling exists). 
     */
    @Override
    public Position<E> sibling(Position<E> p) {
       
       Position<E> parent = parent(p);
       
       if (parent == null) return null; // p must be the root
       
        if (p == left(parent))// p is a left child
            return right(parent);
        // (right child might be null)
        else
        // p is a right child
            return left(parent);
        // (left child might be null)
        }

    /** Returns the number of children of Position p.
     * @param p
     * @return 
     */
    @Override
    public int numChildren(Position<E> p) {
        int count=0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }
    
    /** Returns an iterable collection of the Positions representing p's children.
     * @param p
     * @return 
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return (Iterable<Position<E>>) snapshot;
    }
    
       /** Adds positions of the subtree rooted at Position p to the given snapshot. 
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }
    
    /** Returns an iterable collection of positions of the tree, reported in preorder.
     * @return 
     */
    public Iterable<Position<E>> preorder( ) {
        List<Position<E>> snapshot = new ArrayList<>( );
        if (!isEmpty( ))
            preorderSubtree(root( ), snapshot);
        // fill the snapshot recursively
        return (Iterable<Position<E>>) snapshot;
    }
    
    /** Adds positions of the subtree rooted at Position p to the given snapshot. 
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
        // for postorder, we add position p after exploring subtrees
    }
    
    /** Returns an iterable collection of positions of the tree, reported in postorder.
     * @return 
     */
    public Iterable<Position<E>> postorder( ) {
        List<Position<E>> snapshot = new ArrayList<>( );
        if (!isEmpty( ))
            postorderSubtree(root( ), snapshot);
        // fill the snapshot recursively
        return (Iterable<Position<E>>) snapshot;
    }
    
    /** Returns an iterable collection of positions of the tree in breadth-first order.
     * @return 
     */
    public Iterable<Position<E>> breadthfirst( ) {
        
        List<Position<E>> snapshot = new ArrayList<>( );
        
        if (!isEmpty( )) {
            Queue<Position<E>> fringe = new LinkedQueue<Position<E>>( );
            fringe.enqueue(root( ));
            // start with the root
            while (!fringe.isEmpty( )) {
                Position<E> p = fringe.dequeue( );
                // remove from front of the queue
                snapshot.add(p);
                // report this position
                for (Position<E> c : children(p))
                    fringe.enqueue(c);
                // add children to back of queue
            }
        }
        return snapshot;
    }
    
    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }
    
    /** Returns an iterable collection of positions of the tree, reported in inorder.
     * @return 
     */
    public Iterable<Position<E>> inorder( ) {
        List<Position<E>> snapshot = new ArrayList<>( );
        if (!isEmpty( ))
            inorderSubtree(root( ), snapshot);
        // fill the snapshot recursively
        return snapshot;
    }
    
    /** Overrides positions to make inorder the default order for binary trees.
     * @return 
     */
    @Override
    public Iterable<Position<E>> positions( ) {
        return inorder( );
    }
}
