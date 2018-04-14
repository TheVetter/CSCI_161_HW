package lab108;

/**
 *
 * @author vetter
 * @version 3/25/18
 * @param <E>
 */
public interface Stack<E> {
    /**
     * push and item onto the stack
     * @param e 
     */
    public void push(E e); 
    /**
     * look at the top of the stack
     * @return 
     */
    public E peak();
    /**
     * remove the top of the stack
     * @return 
     */
    public E pop();
    /**
     * size of the stack
     * @return 
     */
    public int size();
    /**
     * tells if stack is empty
     * @return 
     */
    public boolean isEmpty();
}
