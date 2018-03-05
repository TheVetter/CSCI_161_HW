import java.util.NoSuchElementException;
/**Lucky number ordered list 
 *
 * @author Andrew Vetter
 * @version 03/05/2018
 */
public class LuckyNumberList {
    
    private LinkedPositionalList<LuckyNumber> luckyList = null;
    
    /**
     * Basic contstructor  
     */
    public LuckyNumberList(){
        this.luckyList = new LinkedPositionalList<>();
    }
    
    /**
     * adds a lucky number to the end of the list. 
     * @param num
     */
    public void addLuckyNumber(LuckyNumber num){
        luckyList.addLast(num);
    }
    
    /**
     * basic iterator that goes through all the elements 
     */
    private class PositionIterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            if ( cursor == null ) throw new NoSuchElementException( "nothing left " );
            recent = cursor;
            cursor = luckyList.after( cursor );
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException( "nothing to remove" );
            luckyList.remove( recent );         // remove from outer list
            recent = null;              // do not allow remove again until next is called
        }
    }    
    
    /**
     * iterable list of lucky numbers
     */
    private class PositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new PositionIterator( ); }        
    } 
    
    /** Returns an iterable representation of the list's positions.
     * @return  a iterable list 
     */
    public Iterable<Position<LuckyNumber>> positions( ) {
        return new PositionIterable( );  // create a new instace of the inner class
    }
     
    private class EvenPositionIterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            // On the first call to next (i.e. when recent == null) you need to      //<<< new code
            // advance recent until it is pointing to a vowel element.                //<<< new code
            if ( recent == null )                                                    //<<< new code 
            {                                                                        //<<< new code
                while ( cursor != null && !isEven( cursor.getElement().getLuckyNumber()) )    //<<< new code
                    cursor = luckyList.after( cursor );                               //<<< new code
            }                                                                        //<<< new code
                
            if ( cursor == null ) throw new NoSuchElementException( "nothing left " );
            recent = cursor;
            cursor = luckyList.after( cursor );
            
            // advance cursor to the next even numver
            
            while ( cursor != null && !isEven( cursor.getElement().getLuckyNumber()) )
                cursor = luckyList.after( cursor );
            
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException( "nothing to remove" );
            luckyList.remove( recent );         // remove from outer list
            recent = null;              // do not allow remove again until next is called
        }
    }
    
    /**
     * create a list of even iterable lucky numbers
     */
    private class EvenpostionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new EvenPositionIterator(); }        
    }
    
    /**
     * get a list of even lucky numbers
     * @return  
     */
    public Iterable<Position<LuckyNumber>> EvenPositions(){
        return new EvenpostionIterable();
    }
    
    /**
     * tells if the number is even or not
     * @param num, element to test if even
     * @return boolean true if even
     */
    public boolean isEven(int num){
        return (num % 2 ) == 0;
    }
       
    /**
     * check if n is prime between 0 and 9
     * @param n
     * @return boolean. true if n is prime 
     */
    public boolean isPrime(int n){
        return n == 2 || n == 3 || n == 5 || n == 7;  
    }
    
    private class PrimePositionIterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();   // position of the next element to report
        private Position<LuckyNumber> recent = null;               // position of last reported element
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            // On the first call to next (i.e. when recent == null) you need to      //<<< new code
            // advance recent until it is pointing to a vowel element.                //<<< new code
            if ( recent == null )                                                    //<<< new code 
            {                                                                        //<<< new code
                while ( cursor != null && !isPrime( cursor.getElement().getLuckyNumber()) )    //<<< new code
                    cursor = luckyList.after( cursor );                               //<<< new code
            }                                                                        //<<< new code
                
            if ( cursor == null ) throw new NoSuchElementException( "nothing left " );
            recent = cursor;
            cursor = luckyList.after( cursor );
            
            // advance cursor to the next even numver
            
            while ( cursor != null && !isPrime( cursor.getElement().getLuckyNumber()) )
                cursor = luckyList.after( cursor );
            
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException( "nothing to remove" );
            luckyList.remove( recent );         // remove from outer list
            recent = null;              // do not allow remove again until next is called
        }
    }
    
    private class PrimeIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new PrimePositionIterator(); }        
    } 
    
    /** Returns an iterable representation of the list's  containing prime positions.
     * @return  
     */
    public Iterable<Position<LuckyNumber>> primePositions( ) {
        return new PrimeIterable( );  
    }
    
    /**
     * return string representation of the list 
     * @return string 
     */
    @Override
    public String toString( )
    {
        String returnString = "";
               
        Iterator<LuckyNumber> listIterator = luckyList.iterator();
                        
        while ( listIterator.hasNext() )
            returnString += listIterator.next() + " ";
        
        return returnString;
    }
    
}
