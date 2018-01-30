import java.util.Random;
/**
 * the client class that tests Scores class and bag class
 * @author Andrew Vetter
 * @version 01/28/18
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("Beginning of client. Lab 102\n\n");

        //create a sack of random numbers 
        Scores sack = new Scores(100);
        
        System.out.println("populating sack with random numbers. ");
        //polulate sack with 100 random numbers
        Random rand = new Random();
        for(int i = 0; i <100; i++){
            //add random value from -100 to 100
            sack.add(rand.nextInt(200)-100);
        }
        
        //print everything 
        System.out.println(sack);
        
        sack.add(86);
        
        System.out.println("current size of sack: "+ sack.getCurrentSize());
        
        sack.remove();
        
        int index75 = sack.get(75);
        
        System.out.println("frequency of the number at the 75th index: "+ sack.getFrequencyOf(index75));
        
        sack.remove(index75);
        
        System.out.println("frequency of the number at the 75th index after removing one : "+ sack.getFrequencyOf(index75));
        
        System.out.println("frequency of the number 86: "+ sack.getFrequencyOf(86));
        
        if(sack.contains(86)){
            System.out.println("we got the number 86 in there!!\n");
        }else{
            System.out.println("we don't have 86, sorry lads\n");
        }
        
        
        System.out.println("we're done for the day boys. Lab 102 finished");

    }
    
}
