import java.util.Scanner;
/**
 * The client class that tests ArrayBag, LinkedBag, and bag class using the player class
 * @author Andrew Vetter
 * @version 01/28/18
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Beginning of client. Lab 103\n\n");
        //create football team
        ArrayBag footballTeam = new ArrayBag(2);
        
        boolean test = false;
        
        //populate football team
        if(test){
            footballTeam = testData();
        }else{
            keyboardInput(footballTeam);
        }
        
        System.out.println("Remove a random player from football team\n\n");
        
        footballTeam.remove();
        
        System.out.println("adding a new player : Tyler, sitting, 90\n");
        Player tempFootball = new Player("Tyler", "sitting", 90); 
        footballTeam.add(tempFootball);
        
        System.out.println("current amount of players on the team:" + footballTeam.getCurrentSize());
        
        System.out.println("remove Tyler from team\n");
        
        footballTeam.remove(tempFootball);
        
        System.out.println("current amount of players on the team after removing player:" + footballTeam.getCurrentSize());

        System.out.println("\ncreate a course list");
        ArrayBag courses = new ArrayBag(5);
        
        courses.add("ECE 374");
        courses.add("ECE 320/321");
        courses.add("CSCI 161");
        courses.add("Math 266");
        courses.add("ENGR 402");

        System.out.println("drop a random class");
        courses.remove();
        
        System.out.println("\n\nPrint course list:");
        for(int i=0; i<courses.getCurrentSize(); i++){
            System.out.println("\t"+courses.get(i));
        }
       
        
        System.out.println("\n\nLet's create the womens basketball team:");
        LinkedBag basketballTeam = new LinkedBag();
        
        if(test){
            basketballTeam = testDataLinked();
        }else{
            basketballTeam = keyboardInputLinked();
        }
        
        System.out.println("\nRemove a player from the basketball team. I hope its Andrew");
        basketballTeam.remove();
        
        System.out.println("Adding a new player");
        Player mason = new Player("mason", "bench", 56);
        basketballTeam.add(mason);
        
        System.out.println("current amount of players on the team:" + basketballTeam.getCurrentSize());
        
        System.out.println("remove Mason from team\n");
        
        basketballTeam.remove(mason);
        
        
        System.out.println("current amount of players on the team after removing player:" +basketballTeam.getCurrentSize());
        
        
        System.out.println("\n\n\nwe're done for the day boys. Lab 103 finished");

    }
    
    
     /***
     * 
     * @param team
     */
    public static void keyboardInput(ArrayBag team){

        boolean getData = true;

        Scanner keyboard = new Scanner(System.in);
        //my For loop to get player info
        while( getData ){
            String name = null;
            String postition= null;
            int number =0;
            
            System.out.println("please enter the next player");

            // get the player name 
            System.out.println("player name:");
            name = keyboard.nextLine();

            //get position
            System.out.println("players position:");
            postition = keyboard.nextLine();

            // get player number 
            System.out.print("player number:");
            number = Integer.parseInt(keyboard.nextLine());
            
            team.add(new Player(name, postition, number));
                
            //player count 
            System.out.println("player count: " + team.getCurrentSize());
            System.out.println("Do you want to enter another player? enter y/n?");
            String response = keyboard.nextLine();
            
            getData = response.equals("y");
                        
        }
            
    }
    
    /**
     * 
     * @return 
     */
    public static ArrayBag testData(){
        
        ArrayBag testTeam = new ArrayBag(6);
        
        testTeam.add(new Player("Andrew", "running back", 1));
        testTeam.add(new Player("Sidney", "middle forward", 2));
        testTeam.add(new Player("Marie", "goalie", 3));
        testTeam.add(new Player("Thor", "kicker", 4));
        testTeam.add(new Player("Bennett", "tight end", 5));
        testTeam.add(new Player("Aubri", "quarterback", 6));
        
        return testTeam;
    }
    
    /**
     * 
     * @return 
     */
    public static LinkedBag testDataLinked(){
        
        LinkedBag testTeam = new LinkedBag();
        
        testTeam.add(new Player("Andrew", "running back", 1));
        testTeam.add(new Player("Sidney", "middle forward", 2));
        testTeam.add(new Player("Marie", "goalie", 3));
        testTeam.add(new Player("Thor", "kicker", 4));
        testTeam.add(new Player("Bennett", "tight end", 5));
        testTeam.add(new Player("Aubri", "quarterback", 6));
        
        return testTeam;
    }
    
     /**
     * 
     * @return linked bag of all the players entered 
     */
    public static LinkedBag keyboardInputLinked(){

        boolean getData = true;
        LinkedBag FootKey = new LinkedBag();
        int i = 0;

        Scanner keyboard = new Scanner(System.in);
        //my For loop to get player info
        while( getData ){
            String name = null;
            String postition= null;
            int number =0;
            
            System.out.println("please enter the next player");

            // get the player name 
            System.out.println("player name:");
            name = keyboard.nextLine();

            //get position
            System.out.println("players position:");
            postition = keyboard.nextLine();

            // get player number 
            System.out.print("player number:");
            number = Integer.parseInt(keyboard.nextLine());
            
            FootKey.add(new Player(name, postition, number));
                
            //player count 
            System.out.println("player count: " + FootKey.getCurrentSize());
            System.out.println("Do you want to enter another player? enter y/n?");
            String response = keyboard.nextLine();

            getData = response.equals("y");
                        
        }
            return FootKey;
    }
    
}

