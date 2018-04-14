package lab108;

/**
 *
 * @author Andrew Vetter
 * 3/25/18
 * @param <E>
 */
public class LinkedStack<E> implements Stack{

    SinglyLinkedList<E> stack;
    public LinkedStack() {
        stack = new SinglyLinkedList<>();
    };
    
    @Override
    public void push(Object e) {
        stack.addFirst((E) e);
    }

    @Override
    public E peak() {
       return (E)stack.first();
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
}
