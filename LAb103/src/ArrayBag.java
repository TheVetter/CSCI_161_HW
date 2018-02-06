import java.util.Random; 
/**
 *
 * @author Andrew Vetter
 * @verson 01/30/18
 * The scores class implements the bag class. 
 * it's a simple class that handles like the Array class
 */
public class ArrayBag<E> implements Bag<E>{

    private E[] list;
    
    private int count;
            
  /**
   * a basic constructor that initalize it  
   */
    public ArrayBag(){
        this.list = ( E[] ) new Object[50];
        count = 0;
    }
    /***
     * a constructor that inits list to size
     * @param size the size of list 
     */
    public ArrayBag(int size){
        this.list = ( E[] ) new Object[size];
        count = 0;
    }
    /***
     * gets the current size of the array
     * @return the size of the populated array 
     */
    @Override
    public int getCurrentSize() {
        return count;
    }
    /***
     * 
     * @return true if empty, else false
     */
    @Override
    public boolean isEmpty() {
        return (count==0);
    }
   
    @Override
    public boolean isFull() {
        return  list.length == count;
    }

    @Override
    public boolean remove(E element) {
        E sacrifice = element;
        
        for(int j = 0; j<count; j++){
            if(list[j].equals(sacrifice))
            {
                count--;
                return true;
            }
        }         
        
        return false;   
    }

    @Override
    public boolean add(E item) {
        //check if bag is full
        if(list.length == count ){

            //create temp list 2x the size of list 
            E[] temp = (E[])new Object[count*2];
            
            //copy stuff from list to temp 
            for(int i = 0; i<count; i++){
                temp[i] = list[i];
            }
            
            list = temp;
        }
        //add num to end and increase count
        list[count++] = item;
        
        return true;
    }

    @Override
    public E remove() {
        //make sure we have stuff in bag
        if(count==0){
            return null;
        }
        
        Random rand = new Random();
        int i = rand.nextInt(count);
        E sacrifice = list[i];
        
        for(int j = i; j<count-1; j++){
            list[j] = list[j+1];
        }         
        count--;
        
        return sacrifice;
    }

    @Override
    public int getFrequencyOf(E element) {
        int ticker=0;
        for(int i = 0; i<count; i++){
            if(element.equals(list[i])){
                ticker++;
            }   
        }
         return ticker;
    }

    @Override
    public boolean contains(E element) {
        //look for element
        for(int i = 0; i<count; i++){
            //found element exit and return true 
            if(element.equals(list[i])){
                return true;
            }   
        }
        //did not find element return false 
        return false;
    }
       
     /**
     * clears out the list 
     */
    @Override
    public void clear() {
        this.count = 0;
    }
      /***
     * returns the number at index i 
     * @param i
     * @return 
     */
    public E get(int i) {
        
        if(i <= count ){
            return list[i];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
      
    /***
     * To string method returns name of class and list of all elements in the array
     * @return 
     */
    @Override
    public String toString(){
        String temp = new String();
        
        temp = temp + getClass().getName() + "@";
        
        for(int i =0; i <count; i++){
            temp+=list[i] + ":";
        }
        
        return temp;
    }
    /***
     * equals function returns true if the function is equivelent
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o){
        
        if(!(o instanceof ArrayBag)){
            return false;
        }
        
        ArrayBag s = (ArrayBag) o;
        
        if(this.count != s.count){
            return false; 
        }
        
        for(int i=0; i < count; i++){
            if(this.list[i] != s.list[i]){
                return false;
            }
        }   
        return true;   
    }
}
