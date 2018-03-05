/**Client class to test the lucky number iterators 
 *
 * @author Andrew Vetter
 * @version 03/05/2018
 */
public class Lab107Client {
 
    
    public static void main(String[] args) {
        
        System.out.println("Lets start lab 107");
        
        String names[] = { "Andrew", "Ben", "Danille", "tyler", "sidney", "marie", "thor", "Abigail", "Jake", "Aubri"};
        LuckyNumberList list = new LuckyNumberList();
        
        for(int i = 0; i<10; i++){
            list.addLuckyNumber(new LuckyNumber(names[i]));
        }
        
        Iterator<Position<LuckyNumber>> ListIterator = list.positions().iterator();
        
        System.out.print("Using ListIterator on the lucky number list = ");
        while ( ListIterator.hasNext() ){
            LuckyNumber temp = ListIterator.next().getElement();
            
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            
            String prime  = "non-prime";
            int n = temp.getLuckyNumber();
            if(n == 2 || n == 3 || n == 5 || n == 7)
                prime = "prime";
                
            System.out.printf( "\n%10s %6d %10s %10s",  temp.getName(), temp.getLuckyNumber(), even , prime);
        
        }
        System.out.print( "\n\n" );
        
        Iterator<Position<LuckyNumber>> primeIterator = list.primePositions().iterator();
        
               System.out.print("Using Prime Iterator on the lucky number list = ");
        while ( primeIterator.hasNext() ){
            LuckyNumber temp = primeIterator.next().getElement();
            
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            
            String prime  = "non-prime";
            int n = temp.getLuckyNumber();
            if(n == 2 || n == 3 || n == 5 || n == 7)
                prime = "prime";
                
            System.out.printf( "\n%10s %6d %10s %10s",  temp.getName(), temp.getLuckyNumber(), even , prime);
        
        }
        System.out.print( "\n\n" );

        Iterator<Position<LuckyNumber>> evenIterator = list.EvenPositions().iterator();
        
        System.out.print("Using Even Iterator on the lucky number list = ");
        while ( evenIterator.hasNext() ){
            LuckyNumber temp = evenIterator.next().getElement();
            //determine if even
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            //determine if prime
            String prime  = "non-prime";
            int n = temp.getLuckyNumber();
            if(n == 2 || n == 3 || n == 5 || n == 7)
                prime = "prime";
             
            System.out.printf( "\n%10s %6d %10s %10s",  temp.getName(), temp.getLuckyNumber(), even , prime);
        
        }
        System.out.print( "\n\n"
                + "end of lab 107" );        
        
    }
   
}
