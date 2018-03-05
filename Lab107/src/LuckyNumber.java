
import java.util.Random;

/**
 * A Lucky number class with a name and int value randomly generated between 0 and 9
 * @author Andrew Vetter
 * @version 03/05/2018
 */
public class LuckyNumber {
    
    private String name;
    private int luckyNumber;

    /**
     * Make a LuckyNumber
     * @param name the name of the lucky number
     * assign a random number to luckyNumber between 0 and 9 inclusive
     */
    public LuckyNumber(String name) {
        this.name = name;
        Random  rand = new Random();
        //generate random number for luckynumber
        this.luckyNumber = rand.nextInt(9);
        
    }

    /**
     * return the name of the luckyNumber
     * @return name of the lucky number
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the lucky number randomly assigned to this instance 
     */
    public int getLuckyNumber() {
        return luckyNumber;
    }
    
    /**
     * check if obj is equal to this instance of lucky number
     * @param obj
     * @return boolean 
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof LuckyNumber)){
            return false;
        }
        
        LuckyNumber lN = (LuckyNumber) obj;
        
        return lN.luckyNumber == this.luckyNumber && name.equals(lN.name);
    }

    /**
     * return a string representation of this class
     * @return 
     */
    @Override
    public String toString() {
        return getClass().getName() + "@ " + name + ":" + luckyNumber;
    }
    
}
