/**
 * An array based implementation of a double sided Queue 
 * @author Andrew Vetter
 * @version 
 * @param <E> 
 */
public class ArrayDeque<E> implements Deque<E>{

    private E[] queue;
    private int size;
    private int start;
    
    /**
     * your basic default constructor
     */
    public ArrayDeque() {
        this.queue = (E[]) new Object[16];
        this.size = 0;
        this.start = 0;
    }
    
    /**
     * 
     * @return the amount of elements in the Q
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * checks if the Q is empty
     * @return true if size = 0
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 
     * @return the element at the beginning of the Q
     */
    @Override
    public E first() {
        return queue[start];
    }

    @Override
    public E last() {
        return queue[(start + size -1 ) % queue.length];
    }

    @Override
    public void addFirst(E e) {
        //check if we are full
        if(queue.length == size()){
            throw new IllegalArgumentException(" ERROR: HEY this queue is full!!");
        }
        //check if we are at the front of the Q
        if(--start <= 0){
            start = queue.length -1;
        }
        
        if(size ==0){
            start = 0;
        }
        
        //add the element
        queue[start] = e;
        size++;
    }
    
    /**
     * Add an element to the end of the Q 
     * @param e 
     */
    @Override
    public void addLast(E e) {
         //check if we are full
        if(queue.length == size()){
            throw new IllegalArgumentException(" ERROR: HEY this queue is full!!");
        }    
        //add element
        queue[(start + size++) % queue.length] = e;
    }

    /**
     * 
     * @return the removed first element 
     */
    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E temp = first();
        queue[start++] = null;
        return temp;
    }

    /**
     * remove the last element of the queue 
     * @return the last element of the queue
     */
    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        E temp = last();
        queue[(start + --size) % queue.length ] = null;
        return temp;
    }
    
    /**
     * Your equals method that checks if things are equal to this thing 
     * @param obj
     * @return boolean, if obj is equal to this instance of arrayDeque
     */
    public boolean equal( Object obj){
        if(!(obj instanceof ArrayDeque)){
            return false;
        }
        
        ArrayDeque test = (ArrayDeque) obj; 
        //check if size and start are equal
        if((this.size != test.size) || (this.start != test.start)){
            return false;
        }
        //check if q is equal
        for(int i = 0; i<size; i++ ){
            if(!queue[this.start + i].equals(test.queue[test.start + i])){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 
     * @return string representation of array Deqeu
     */
    @Override
    public String toString(){
        String temp = getClass().getName() + "@ Size:" + size + " Start:" +start;
        
        for(int i = 0; i<queue.length; i++ ){
            if(queue[i] != null){
                temp += ":" + queue[i];
            }
        }
        
        return temp;      
    }
    
    
}
