import java.util.Scanner;

/**
 *
 * @author Andrew Vetter
 * @version 01/22/2018
 * creates a list on Employees either from user or predefine. 
 * prints out employee list. 
 * gives everyone a raise.
 * Prints out the list again 
 * test a set of employees against one another. 
 */
public class Client {
    
    public static void main(String[] args){
    
        boolean test = false;
        
        Employee[] employeeList;
        
        //populate employees 
        if(test){
            employeeList = testData();
        }else{
            employeeList = keyboardInput();
        }
        
        System.out.println("List of employees:\n ");
        //list employees 
        for(int i =0; i< 10; i++){
            System.out.println(employeeList[i]);
        }
    
        
        System.out.println("\ngive employees a 10% raise \n");
        // give the company a raise
        for(int i = 0; i<10; i++){
            //see if the employ is salaried
            if(employeeList[i] instanceof Hourly){
                
                Hourly tempHr = (Hourly)employeeList[i];
                tempHr.setHourlyRate(tempHr.getHourlyRate()*1.10);
                employeeList[i] = tempHr;
            }
            else if(employeeList[i] instanceof Salaried){
                
                Salaried tempSal = (Salaried)employeeList[i];
                tempSal.setSalary((int)(tempSal.getSalary() * 1.10));
                employeeList[i] =tempSal;
            }
            else{
                continue;
            }
            
        }
        
        System.out.println("after the raise");
        System.out.println("List of employees: ");
    
        //list employees 
        for(int i =0; i< 10; i++){
            if(!(employeeList[i] == null))
            System.out.println(employeeList[i]);
        }
        
        System.out.println("\ntest the equals function:\n");
        
        Employee testSal1 = new Salaried("title 1", 3000, 1, "joe");
        Employee testSal2 = new Salaried("title 1", 3000, 1, "joe");
        Employee testHr1  = new Hourly(5, "Andrew", "sitting", 12.86);
        Employee testHr2  = new Hourly(5, "Andrew", "sitting", 12.86);
        
        System.out.println("test Salaried1 and Hourly1. Result: " + testSal1.equals(testHr1));
        System.out.println("test Salaried1 and Salaried 2. Result: " + testSal1.equals(testSal2));
        System.out.println("test Salaried2 and Hourly2. Result: " + testSal2.equals(testHr2));
        System.out.println("test Hourly 2 and Hourly1. Result: " + testHr2.equals(testHr1));
        System.out.println("\n\nend of main");
    }
    
          
    /***
     * 
     * @return Employee[]
     */
    public static Employee[] testData(){
        Employee[] testList = new Employee[10];
        
           testList[0] = new Salaried("manager", 1000, 100, "blake");
           testList[1] = new Hourly(500, "michelle", "tree planter", 8.25);
           testList[2] = new Salaried("RA", 3000, 200, "bennett");
           testList[3] = new Hourly(600, "Jake", "student", 10.25);
           testList[4] = new Salaried("teacher", 8000, 654, "nathen");
           testList[5] = new Hourly(123, "megan", "clerk", 9.00);
           
           return testList;       
    }
    /***
     * 
     * @return Employee[]
     */
    public static Employee[] keyboardInput(){

        boolean getData = true;
        Employee[] employeeList = new Employee[10];
        int i = 0;

        Scanner keyboard = new Scanner(System.in);

        while( getData ){
            String name;
            int id;
            String postition;
            int salary;
            double hrPay;
            
            
            System.out.println("Is the employee Salaried? enter Y/n");
                String response = keyboard.next(); 
            if(response.equals("y")){
                // questions for salaried employee
                
                // get the employee name 
                System.out.println("employee name?");
                name = keyboard.next();
                
                // get employee id 
                System.out.println("employee id");
                id = keyboard.nextInt();
                
                //get position
                System.out.println("what is the employee's title?");
                postition = keyboard.next();
                
                //get salary 
                System.out.println("employee salary?");
                salary = keyboard.nextInt();
                
                employeeList[i] = new Salaried(postition, salary, id, name);
                
            }else if(response.equals("n")){
                // questions for hourly employee
                
                // get the employee name 
                System.out.println("employee name?");
                name = keyboard.next();
                
                // get employee id 
                System.out.println("employee id");
                id = keyboard.nextInt();
                
                //get position
                System.out.println("what is the employee's postition?");
                postition = keyboard.next();
                
                //get salary 
                System.out.println("employee's hourly pay?");
                hrPay = keyboard.nextDouble();
                
                employeeList[i] = new Hourly(id, name, postition, hrPay);
                
            }else {
                
                continue;
            }
            
            i++;
            
            System.out.println("employeecount: " + employeeList[0].getEmployeeCount());
            System.out.println("Do you want to enter another employee? enter y/n?");
            response = keyboard.next();
            
            if(response.equals("y")){
                getData = true;  
            }
            else{
                getData = false;
            }
                        
        }
            return employeeList;
    }
}
