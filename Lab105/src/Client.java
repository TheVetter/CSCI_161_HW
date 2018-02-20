/**
 * your basic main class to test our singly linked and doubly linked list classes
 * @author Andrew Vetter
 * @version 02/18/18
 */
public class Client {
    
    
    public static void main(String[] args) {
        
        System.out.println("Lets start off lab 5!\n");
        
        // test our singley linked list class 
        SinglyLinkedList topTen;
        topTen = new SinglyLinkedList<>();
        
        System.out.println("Make a singleyLinkedList");
        for(int i = 1; i<11; i++){
            topTen.addLast(i);
        }
        
        System.out.println("Print out singley linked List: \n" + topTen);
        
        System.out.println("\nremoved the first element : " + topTen.removeFirst());
        
        System.out.println("\nPrint out that List again: \n" + topTen);
        
        System.out.println("\n lets start Part B of part 1");
        
        //make a doubling linked list
        DoublyLinkedList topTen_double;
        topTen_double = new DoublyLinkedList();
        
        //populate list 
        for(int i =1; i<=10; i++){
            topTen_double.addLast(i);
        }
        
        System.out.println("Print out doubly linked List: \n" + topTen_double);
        
        System.out.println("\nremoved the first element. that element was : " + topTen_double.removeFirst());
        System.out.println("\nremoved the last element. that element was : " + topTen_double.removeLast()); 
        
        System.out.println("\nPrint out the Doubly linked list again again: \n" + topTen_double);
        
        //start part 2 
        //set limit
        long limit = 100000000;

        SinglyLinkedList test_single = new SinglyLinkedList();
        //make timestamp
        long startTime = System.currentTimeMillis();
        //test singlelinked list
        for(int i =0; i<limit; i++){
            test_single.addFirst(i);
        }
        long currentTime = System.currentTimeMillis() ;
        long timeElapsed = currentTime- startTime;
        
        String n = String.format("N = %,d", limit);
        String time = String.format("Time(msec) = %,6d", timeElapsed);
        System.out.printf("\nSingleLinked \t%s \t%s\n", n, time);
        
        // test the doubly linked list 
        DoublyLinkedList test_Double = new DoublyLinkedList();
        //make timestamp
        startTime = System.currentTimeMillis();
        //test doubly linked list time
        for(int i =0; i<limit; i++){
            test_Double.addFirst(i);
        }
        //time math
        currentTime = System.currentTimeMillis() ;
        timeElapsed = currentTime- startTime;
        
        //make formatted string
        time = String.format("Time(msec) = %,6d", timeElapsed);
        System.out.printf("DoublyLinked \t%s \t%s\n", n, time);
    
    
        System.out.println("End of Lab 105. there will be more next week");
    }
}
