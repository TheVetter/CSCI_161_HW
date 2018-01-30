/**
 *
 * @author vetter
 * @version 01/18/2018
 * The hourly class defines an hourly employee. Hourly extends Employee. 
 * Hourly takes the arguments id, Name, position, hourly rate. 
 */
public class Hourly extends Employee {
    
    private static int hourlyEmployeeCount = 0;
    private String position;
    private double hourlyRate;
    
    /***
     * 
     * @param id
     * @param name
     * @param position
     * @param hourlyRate 
     */
    public Hourly( int id, String name, String position, double hourlyRate){
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.position = position;
        hourlyEmployeeCount++;
    }
    /***
     * 
     * @return int
     */
    public static int getHourlyEmployeeCount() {
        return hourlyEmployeeCount;
    }
    /***
     * 
     * @return  String
     */
    public String getPosition() {
        return position;
    }
    /***
     * 
     * @return double
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
    /***
     * 
     * @param position 
     */
    public void setPosition(String position) {
        this.position = position;
    }
    /***
     * 
     * @param hourlyRate 
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    /***
     * 
     * @return String
     */ 
    public String toString(){
        return super.toString() + ":" + getClass().getName() + "@" + hourlyEmployeeCount +":" + position + ":" + hourlyRate; 
    }
    /***
     * 
     * @param o
     * @return  
     */
    public boolean equals (Object o ){
        
        if ( !( o instanceof Hourly ) ){
            return false;
        }
        
        Hourly h = (Hourly) o;
        
        System.out.println("test info:"+ super.equals(o)+"::" + position.equals(h.position) +":"+ (Math.abs( hourlyRate - h.hourlyRate) < 0.01));
        
        return super.equals(o) 
                && position.equals(h.position)
                && Math.abs( hourlyRate - h.hourlyRate) < 0.01;
        
    }
}
