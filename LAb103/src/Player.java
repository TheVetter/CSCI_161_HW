/**
 *
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

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
