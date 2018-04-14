/** Main Client class of lab 110
 *
 * @author Andrew vetter
 */
public class lab110Client {
 
    public static void main(String[] args) {
        
        System.out.println("Beginning of lab 110");
        
        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue();
        
        System.out.println("~~~~~~~~~~~insterting Entries into queue~~~~~~~~~~~~~");
        
        Entry<Integer, String> addition = heap.insert(7, "seven");
        System.out.printf("inserting Entry ( %d , %s )\n", addition.getKey(), addition.getValue() );
        
        addition = heap.insert(5, "five");
        System.out.printf("inserting Entry ( %d , %s )\n", addition.getKey(), addition.getValue() );
        
        addition = heap.insert(1, "one");
        System.out.printf("inserting Entry ( %d , %s )\n", addition.getKey(), addition.getValue() );
        
        
        System.out.println("~~~~~~~~~~~Removing Entries from queue~~~~~~~~~~~~~");
        while(!heap.isEmpty()){
            Entry<Integer, String> temp = heap.removeMin();
            System.out.printf("removeMin() returns Entry ( %d , %s )\n", temp.getKey(), temp.getValue() );
        }
        
        
        System.out.println("end of lab 110");
        
        
    }
    
    
}