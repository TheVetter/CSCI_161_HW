import java.util.Random;

/**
 * 
 * @author Andrew vetter
 * @version 2/4/18
 */
public class LinkedBag<E> implements Bag{
    
    SinglyLinkedList<E> list;
    int count;

    public LinkedBag() {
    
        this.list = new SinglyLinkedList();
        this.count = 0;
    }

    @Override
    public int getCurrentSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean add(Object item) {
        list.addLast((E)item);
        count++;
        return true;
    }

    @Override
    public E remove() {
        Random rand = new Random();
        int sacrifice = rand.nextInt(count);
        int place=0;
        for(int i =0; i <count; i++){
            //remove the thing at the begining 
            E first = list.removeFirst();
            if(place == sacrifice){
                count--;
                return first;
            }
            //readd the item to the end 
            list.addLast(first);
            place++;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        
        for(int i =0; i <count; i++){
            //remove the thing at the begining 
            E first = list.removeFirst();
            if(element.equals(first)){
                count--;
                return true;
            }else{
            //re-add the item to the end 
            list.addLast(first);
        
            }   
        
        }
        return false;
    }   
    
    @Override
    public void clear() {
        //remove all elements
        for(int i =0; i < count; i++){
            list.removeFirst();
        }
        //reset count
        count = 0;
    }

    @Override
    public int getFrequencyOf(Object element) {
        int frequency=0;
        E test; 
        for(int i = 0; i <count; i++){
            //pull the first element
            test = list.removeFirst();
            if(element.equals(test)){frequency++;}
            list.addLast(test);
        }
        
        return frequency;
    }

    @Override
    public boolean contains(Object element) {
        E test; 
        for(int i = 0; i <count; i++){
            //pull the first element
            test = list.removeFirst();
            if(element.equals(test)){
                return true;
            }
            list.addLast(test);
        }
        return false;
    }
    
    /***
    * returns the number at index i 
    * @param i
    * @return Elemment at I
    */
    public E get(int i) {
        
        if( i < count ){
            
            E test;
            int place =0 ; 
            for(int j = 0; i<count; j++ ){
                test = list.removeFirst();
                if(place == j){
                    return test;
                }
                
                list.addLast(test);
            }
         
        }
        return null;
    }
    
    @Override
    public String toString(){
        //start the String 
        String value =getClass().getName()+"@";
        
        E test;
        for(int i = 0; i <count; i++){
            //pull the first element
            test = list.removeFirst();
            //add it to the string 
            value = value + test +":";
            //throw it back in the list 
            list.addLast(test);
        }
        
        return value;
    }
    
    public boolean equals(Object o){
        //make sure it's a linked bag 
        if (!(o instanceof LinkedBag)){
            return false;
        }
        boolean compare = true;
        LinkedBag lb = (LinkedBag)o;
        
        E testList;
        E testBag;
        //check all the nodes
        for(int i = 0; i <count; i++){
            //pull the first element of each
            testList = list.removeFirst();
            testBag = (E)lb.list.removeFirst();
            
            if(!testBag.equals(testList)){//compare each element
                compare = false;
            }
            //return both 
            list.addLast(testList);
            lb.list.addLast(testBag);
        }
        
        return compare;
    }
}
