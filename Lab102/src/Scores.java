import java.util.Random; 
/**
 *
 * @author Andrew Vetter
 * @verson 01/30/18
 * The scores class implements the bag class. 
 * it's a simple class that handles like the Array class
 */
public class Scores implements Bag{

    private int[] list;
    
    private int count;
            
  /***
   * a basic constructor that initalize it  
   */
    public Scores(){
        this.list = new int[50];
        count = 0;
    }
    /***
     * a constructor that inits list to size
     * @param size the size of list 
     */
    public Scores(int size){
        this.list = new int[size];
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
    /***
     * adds a number to the array 
     * @param num 
     */
    @Override
    public void add(int num) {
        //check if list is maxed out 
//        System.out.println("length of list" + list.length + " count: "+ count);
        if(list.length == count ){
//            System.out.println("in the if ");
            //create temp list 2x the size of list 
            int[] temp = new int[count*2];
            
            //copy stuff from list to temp 
            for(int i = 0; i<count; i++){
                temp[i] = list[i];
            }
            
            list = temp;
           //clear temp
//           temp = null;
        }
        //add num to end and increase count
        list[count++] = num;
    }
    /***
     * removes a random number from the array and fills the hole 
     */
    @Override
    public void remove() {
        
        Random rand = new Random();
        int num = rand.nextInt(count);
       
        for(int i=num;i<count; i++ ){
            list[i] = list[i+1];
        }
    }
    /***
     * removes the first instance of num 
     * @param num 
     */
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
                count--;
                break;
            }
        }
    }
    /***
     * returns the number at index i 
     * @param i
     * @return 
     */
    public int get(int i) {
        
        if( i <= count ){
            return list[i];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    /***
     * clears out the list 
     */
    @Override
    public void clear() {
        
        this.list = null; 
        this.count = 0;
    }
    /***
     * returns the frequency of Num 
     * @param num
     * @return 
     */
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
    /***
     * returns true if it contains num, otherwise false
     * @param num
     * @return 
     */
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
    /***
     * To string method returns name of class and list of all elements in the array
     * @return 
     */
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
    public boolean equals(Object o){
        
        if(!(o instanceof Scores)){
            return false;
        }
        
        Scores s = (Scores) o;
        
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
