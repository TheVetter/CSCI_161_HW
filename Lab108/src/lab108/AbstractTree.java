package lab108;

/**An abstract base class providing some functionality of the Tree interface.
 *
 * @author Andrew Vetter
 * @version 3/8/18
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {
    
    @Override
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    
    @Override
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
  
    @Override
    public boolean isRoot(Position<E> p) { return p == root( ); }
    
    /** Returns the number of levels separating Position p from the root.
     * @param p
     * @return int 
     */
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    
    /** Returns the height of the subtree rooted at Position p.
     * @param p
     * @return 
     */
    public int height(Position<E> p) {
    int h = 0;
    // base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
 
}

