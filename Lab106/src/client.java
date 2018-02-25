/** the main class of Lab106 that tests the doubly ended queues
 *
 * @author Andrew Vetter
 * @version 2/24/18
 */
public class client {
    static int playerCount = 0; 

    public static void main(String[] args) {
        
        System.out.println("And in this corner we have Lab 106 ready to square off\n\n");
//        playerCount =0;
        
        //test 
        dequeTest(new ArrayDeque());
        
        dequeTest(new ListDeque());
        
        System.out.println("\nAnd WE HAVE OUR WINNNER LAB 106 IS TAKING HOME THE GOLD");
    }
    
    /**Tests any sort of Deque 
     * 
     * @param que 
     */
    public static void dequeTest(Deque que){
    
        System.out.println("Testing this Deque: " + que.getClass().getName());
        
        System.out.println("Let's add 8 players to the beginning of the que and 8 the end");
        for(int i =0; i<8; i++){
            //add a player to the front
            que.addFirst(generatePlayer());
            //add a player to the end 
            que.addLast(generatePlayer());
        }
        
        System.out.println("\nlet's see the line up of our team: " + que);
        
        System.out.println("Remove a player from front of the queue. player removed: "+ que.removeFirst());
        
        System.out.println("remove a player from the end: player removed: " + que.removeLast());
        
        System.out.println("\nlets add more players to the team");
        //add 3 more players
        try{
            que.addLast(generatePlayer());
            que.addFirst(generatePlayer());
            que.addFirst(generatePlayer());
            //should error out on the array deque 
        }catch( IllegalArgumentException iae){
            System.out.println("\tqueue is full. can't add more players");
        }
        
        System.out.println("size of the queue: " + que.size() + " is the queue empty: " + que.isEmpty());
        System.out.println("First player on the team: " + que.first() + " and the last player of the team: " + que.last());
        
        System.out.println("\ncurrent players on the team: " + que);
        
        System.out.println("check if the array equals it's self: "+que.equals(que));
    
    }
    
    /**
     * generates a player so i don't have to 
     * @return player
     */
    public static Player generatePlayer(){
        playerCount++;
        return new Player("Name" + playerCount, "position" + playerCount, playerCount);
    }
    
}
