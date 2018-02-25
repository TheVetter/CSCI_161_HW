/**
 * A Linked list implementation of a double sided queue 
 * @author Andrew Vetter
 * @version 
 * @param <E> 
 */
public class ListDeque<E> implements Deque<E>{
    
    private DoublyLinkedList<E> list;
    
    /**
     * your basic constructor for constructing 
     */
    public ListDeque() {
     list = new DoublyLinkedList<>();
    }
    
    /**
     * 
     * @return the size of the double ended Q
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 
     * @return true if Q is empty else false
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 
     * @return the first element of the Q
     */
    @Override
    public E first() {
        return list.first();
    }

    /**
     * 
     * @return the last element of the Q
     */
    @Override
    public E last() {
        return list.last();
    }

    /**
     * add an element to the Q
     * @param e 
     */
    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    /**
     * add an element to the end of the Q
     * @param e 
     */
    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    /**
     * 
     * @return the first element of the Q and remove it 
     */
    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    /**
     * 
     * @return remove the last element of the Q
     */
    @Override
    public E removeLast() {
        return list.removeLast();
    }

    /**
     * Check if the object equals this Q
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ListDeque)){
            return false;
        }
        
        ListDeque test = (ListDeque<E>) obj;
        for(int i =0; i<size(); i++){
            //pop
            E temp1 = this.removeFirst();
            E temp2 = (E) test.removeFirst();
            //push
            this.addLast(temp1);
            test.addLast(temp2);
            //check equality
            if(!temp1.equals(temp2)){
                return false;
            }
        }
        return true;
    }

    /**
     * a generic too string method
     * @return a string about the class 
     */
    @Override
    public String toString() {
        
        String temp = getClass().getName() + "@";
        E holder;
        //get each element of the Q
        for(int i=0; i<size(); i++){
            holder = this.removeFirst();
            temp+= " : "+ holder;
            this.addLast(holder);
        }
        return temp;
    }
    
}
