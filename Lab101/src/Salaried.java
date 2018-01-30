/**
 *
 * @author  Andrew Vetter
 * @version 01/22/2018
 * this class define a Salaried Employee. A salaried employee has a title, salary, ID, and Name. 
 * this class extends the employee class. 
 */
public class Salaried extends Employee{
    
    private static int salariedEmployeeCount = 0;
    private String title;
    private int salary;
  
    /***
     * 
     * @param title
     * @param salary
     * @param newId
     * @param newName 
     */
    public Salaried(String title, int salary, int newId, String newName) {
        super(newId, newName);
        this.title = title;
        this.salary = salary;
        salariedEmployeeCount++;
    }
    /***
     * 
     * @return int 
     */
    public static int getSalariedEmployeeCount() {
        return salariedEmployeeCount;
    }
    /***
     * 
     * @return String
     */
    public String getTitle() {
        return title;
    }
    /***
     * 
     * @return int
     */
    public int getSalary() {
        return salary;
    }
    /***
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /***
     * 
     * @param salary 
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    /***
     * 
     * @return super.toString() + class name + salaried EmployeeCount + title + salary 
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" +  salariedEmployeeCount + ":" + title + ":" + salary; 
    }
    /***
     * 
     * @param o
     * @return boolean  
     */
    public boolean equals( Object o){
        if ( !( o instanceof Salaried ) ){
            return false;
        }
               
        Salaried sal = ( Salaried ) o;
        System.out.println("test info:"+ super.equals(o)+"::" + title.equals(sal.title) +":"+ (this.salary==sal.salary));
        
        
        return super.equals(o)
                && this.salary == sal.salary
                && this.title.equals(sal.title);        
    }
    
    
}
