/**
 *A sports ball player that has a name, position played, and jersey number
 * @author Andrew Vetter
 * @version 02/05/2018
 */
public class Player {
    private String name;
    private String position;
    private int jerseyNumber;

    public Player() {
    }

    public Player(String name, String position, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }
    /**
     * 
     * @return The name of the player
     */
    public String getName() {
        return name;
    }
    /**
     * set the name of the player
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return the Position of the player
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * set the position of the player
     * @param position 
     */
    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * get the Jersey number of the player
     * @return int
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * set the Jersey Number of the player
     * @param jerseyNumber 
     */
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    
    /**
     * 
     * @return a string of everything 
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + name + ":" + position + ":" + jerseyNumber;
    }
    /**
     * 
     * @param obj
     * @return check if an object equals 
     */
    @Override
    public boolean equals(Object obj) {
        
        if(!(obj instanceof Player)){
            return false;
        }
        
        Player p = (Player) obj;
        
        return ((p.name.equals(this.name)) 
                && (p.position.equals(this.position))
                && (p.jerseyNumber == this.jerseyNumber));   
    }
    
}
