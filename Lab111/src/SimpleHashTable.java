
import java.security.InvalidParameterException;

/** a Simple string hash table impementation 
 *
 * @author Andrew Vetter
 */
public class SimpleHashTable {
    
    private SinglyLinkedList<String>[] table;
    private int shift;
    private int a;
    private int b;
    private int p;
    private int size;
    private int longestChain;
    private int numColisions;
    
    public SimpleHashTable(int size){
        this.size = 0;
        this.longestChain = 1;
        this.numColisions = 0;
        this.a = 1;
        this.b = 0;
        int n = (int)(nextPrime(size)*1.1);
        this.p = nextPrime(n);
        table = new SinglyLinkedList [ n ];
        shift = 0;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public int size(){
        return this.size;
    }
    
    public void put(  String  string  ){
        int key = hashKey(string);
        try{
            table[key].addLast(string);
        } catch(NullPointerException npe){
            table[key] = new SinglyLinkedList<>();
            put(string);
        } 
        if(table[key].size() > 1){
            numColisions++;
            if(table[key].size() > longestChain){
                longestChain = table[key].size(); 
            }
        }else{
            this.size ++;
        }
       
    }
    
    public String get(  String  string  ){
        int key = hashKey(string);
        for(int i =0; i < table[key].size(); i++){
            if (string.equals(table[key].first()))
                return string;
            else{
                table[key].addLast(table[key].removeFirst());
            }
        }
        return null;
    }
    
    public String remove(  String  string  ){
       int key = hashKey(string);
        for(int i =0; i < table[key].size(); i++){
            if (string.equals(table[key].first())){
                this.size --;
                return table[key].removeFirst();
            }
            else{
                table[key].addLast(table[key].removeFirst());
            }
        }
        return null;
        
    }
    
    private int hashKey(  String string  ){
      return Math.abs(compressedHashCode(cyclicHashCode(string, shift)));
    }
    
    private int cyclicHashCode(  String  string,  int  shift  ){
        int h=0;
        for (int i=0; i<string.length(); i++) {
            h = (h << shift) | (h >>> (32-shift));
            h += (int) string.charAt(i);
        }
        return h;
    }
    
    public int getShift( ){
        return shift;
    }
    
    public void setShift( int shift ){
        if(!isEmpty()){
            throw new InvalidParameterException("can't change shift with elements in the hastable");
        }
        if(shift <0 || shift > 32){
            throw new InvalidParameterException("valid shift amount [0:32]");
        }
        this.shift = shift;
    }
    
    private int compressedHashCode(  int  hashCode  ){
        return ((a*hashCode + b) % p) % table.length;
    }
    
    public void setPmad( int p ){
        if(!isEmpty()){
            throw new InvalidParameterException("can't change p with elements in the hastable");
        }
        if(p<table.length)
            throw new InvalidParameterException("p not big enough");
        this.p = p;
    }
    
    public int getPmad( ){
        return p;
    }
    
    public void setAmad( int a ){
        if(!isEmpty()){
            throw new InvalidParameterException("can't change a with elements in the hastable");
        }
        if (a <= 0 || a > p-1){
            throw new InvalidParameterException("valid range for a is (0, p-1]");
        }
        this.a = a;
    }
    
    public int getAmad( ){
        return a;
    }
    
    public void setBmad( int b ){
        if(!isEmpty()){
            throw new InvalidParameterException("can't change b with elements in the hastable");
        }
        if( b <0 || b > p-1 )
            throw new InvalidParameterException("valid range for B is [0,p-1]");
        this.b = b;
    }   
    
    public int getBmad( ){
        return b;
    }
    
    public int numCollisions( ){
        return numColisions;
    }
    
    public int longestChain( ) {
        return longestChain;
    }
    
    public double loadFactor( ){
        return (double)size / (double)table.length;
    }
    
    public int nextPrime(int num){
        int i,j;
           
        for(j=num+1;;j++)
        {

            for(i=2;i<j;i++)
            {
                if(j%i==0)
                break;
            }

            if(i==j)
            {
//                System.out.println("Next prime no is:"+j);
                return j;
            }
        }
    }
}
