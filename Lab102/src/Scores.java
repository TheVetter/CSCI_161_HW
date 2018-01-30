/**
 *
 * @author vetter
 */
public class Scores implements Bag{

    private int[] list;
    
    private int count;
            
    
    public Scores(){
        this.list = new int[50];
        count = 50;
    }
    public Scores(int size){
        this.list = new int[size];
        count = size;
    }
    @Override
    public int getCurrentSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count==0);
    }

    @Override
    public void add(int num) {
        //check if list is maxed out 
        if(list.length == count ){
            //create temp list 2x the size of list 
            int[] temp = new int[count*2];
            
            //copy stuff from list to temp 
            for(int i = 0; i<count*2; i++){
                temp[i] = list[i];
            }
            
           //clear temp
           temp = null;
        }
        //add num to end and increase count
        list[count++] = num;
    }

    @Override
    public void remove() {
        if(count<0){count--;} // only decrement when we have values in the array
    }

    @Override
    public void remove(int num) {
        
        //look for num and i
        for(int i = 0; i <count; i++){
            
            //see if it contains num 
            if(list[i]==num){
                //store location of i
                for(int k = i;k<count-1; k++){
                    list[i] = list[i+1];
                }
                break;
            }
        }
        
    }

    @Override
    public void clear() {
        
        this.list = null; 
        count = 0;
    }

    @Override
    public int getFrequencyOf(int num) {
        // check if we have values
        if(count == 0){
              return 0;
        }
        //create frequency holder
        int numCount= 0;
        for(int i = 0; i <count; i++){
            //count the number of times the num is in the array
            if(list[i]==num){
                numCount++;
            }
        }
        return numCount;
    }

    @Override
    public boolean contains(int num) {
        //make sure we have an array to check
        if(count == 0){
              return false;
        }
        //look for num and return true
        for(int i = 0; i <count; i++){
            
            //see if it contains num 
            if(list[i]==num){
                return true;
            }
        }
        
        return false;
    }
  
}
