/**
 *
 * @author Andrew Vetter
 * @version 01/22/2018
 * The Employee class defines an Employee in a company. The employee has the arguments ID and Name.
 */
public class Employee {
    
    
    private static int employeeCount =0;
    private int id;
    private String name;
    /***
     * 
     * @param Id
     * @param Name 
     */
    public Employee(int newId, String newName) {
        this.id = newId;
        this.name = newName;
        employeeCount++;
    }
    /***
     * 
     * @param newId 
     */
    public void setId(int newId){
        this.id = newId;
    }
    /***
     * 
     * @param newName 
     */
    public void setName(String newName){
        this.name = newName;
    }
    /***
     * 
     * @return id
     */
    public int getId(){
     return id;   
    }
    /***
     * 
     * @return name
     */
    public String getName(){
        return name;
    }
    /***
     * 
     * @return int
     */
    public int getEmployeeCount(){
        return employeeCount;
    }
    /***
     * 
     * @return String
     */
    public String toString(){
        
    return getClass().getName() + "@" + employeeCount + ":" + id + ":" + name;    
    }
    /***
     * 
     * @param o
     * @return boolean
     */
    public boolean equals( Object o){
        
        Employee e = (Employee) o;
        
        return this.id == e.getId()
                && this.name.equals(e.getName());  
    }    
}
