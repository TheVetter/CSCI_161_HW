import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * A client class to test the Recurssion methods in the recussion class
 * @author Andrew Vetter
 */
public class Recurssive_Client {

    
    public static void main(String[] args) {
        
        System.out.println("Begining lab104 let's hope this shit works!!!!\n\n");
         
        
        if(showconfirmDialog("do you want to start Lab104")==0 ){
            boolean running = true;
            while(running){
                running = runMenu();
            }
        }
        
        
        System.out.println("End of lab 104 please come back next time");
    }
    
    /**
     * Call the harmonic method of the recursive class. 
     * Uses joption pane to prompt input for harmonic method 
     * prints the result 
     */
    private static void callHarmonic() {
        //create joption pane to get n from user
        String response = JOptionPane.showInputDialog( null, "Please enter an integer for the Harmonic method", "Harmonic method", 0 );
        
        System.out.println("run harmonic method. user input = " +response);
        double result = Recursion.harmonic(Integer.parseInt(response));
        //output result to user
        showMessageDialog("result of harmonic method " + result);
        
    }
    
    /**
     * calls the isabele method from the recurssion class. 
     * uses Joption panes to get input and display output
     */
    private static void callIsabele() {
        //create joption pane to get path to file from user
        String response = JOptionPane.showInputDialog( null, "Please enter the path to the file of integers", "Isabele's method", 0 );
        
        int[] temp = getArrayForFile(response);
        //Make sure file is valid 
        if(!(temp==null)){
            
            System.out.println("run isabeles method. user input = " +response);
            
            try {
                
                int result = Recursion.isabelTechnique(temp);
                //output result to user
                showMessageDialog("result of harmonic method " + result);
                
            } catch (ArraynotBase2 ex) {
                
                System.out.println("Array is not of base 2");
                showMessageDialog("data in file is not base 2.\n "
                                    + "please check file");
            }
            
        }
    }
    
    
    
     /**
      * basic dialog pane pop up. pass a string with what you want displayed.
      * @param response 
      */
    public static void showMessageDialog(String response)
    {        
        JOptionPane.showMessageDialog(null, response, response, 0);        
    }
    
    /**
     * create a simple joption plane with a confirm box 
     * please pass in the message to be confirmed 
     * returns 0 if yes; 1 if no
     * @param response
     * @return 
     */
    public static int showconfirmDialog(String response)
    {
        //record mesage in terminal 
        System.out.println(response);
        //make joptions plane for with mesage
        return JOptionPane.showConfirmDialog(null, response, response, 0);
        
    }

    /**
     * the Menu for the application returns true if to keep running false to exit
     * @return boolean
     */
    private static boolean runMenu() {
        String response;
        
        String optionString = "A) run the harmonic method\n"
                + "B) to run isabelles method\n"
                + "C) to run the list method\n"
                + "D) to exit program";
        
        response = JOptionPane.showInputDialog( null, optionString, "Recurssive Class", 0 );        
        
        switch ( response ) 
        {
            case "a" :
            case "A" :
                System.out.println("Calling harmonic method");
                callHarmonic();
                break;
            case "b" :
            case "B" :
                System.out.println("Calling isabeles method\n"); 
                callIsabele();
                break;
            case "c" :
            case "C" : 
                System.out.println("Call method 3");
                callList();
                
                break;
            case "d" :
            case "D" :    
                System.out.println("Setting sential flag to exit loop");
                
                //double check with use on exit
                if (showconfirmDialog("do you want exit program?") == 0){
                    return false;
                }
                break;
            default :
                showMessageDialog("please enter either 'A', 'B', 'C', or 'D'\n without quaotes obviously");
                System.out.println("please enter either 'A', 'B', 'C', or 'D'\n without quaotes obviously");
                break;
        
        }    
        
        return true;
    }
    
    /**
     * takes a text file that has ints in it and converts to a int[]
     * @param response
     * @return int[] from the file 
     */
    private static int[] getArrayForFile(String response) {
        File file = new File(response);

        Scanner in;
        try {
             in = new Scanner(file);
        } catch (FileNotFoundException ex) {
               System.out.println("File not found");
               showMessageDialog("ERROR: File not found.\n");
               return null;
        }
        //read from file and throw into an array. 
        ArrayBag bag = new ArrayBag();
        while(in.hasNext()){
            //check if int
            if(in.hasNextInt()){
                bag.add(in.nextInt());
            }
            else{
                in.next();
            }
        }
        
        //convert bag to array 
       int[] result = new int[bag.getCurrentSize()];
       for(int i =0; i<bag.getCurrentSize(); i++){
           result[i] = (int)bag.get(i);
       }
        
       return result;

    }

    /**
     * runs the list method from the recurssive class 
     * uses joption pane to get input. displays output in terminal
     */
    private static void callList() {
        
        String response = JOptionPane.showInputDialog( null, "Please enter the path to the folder", "List method", 0 );
        File file = new File(response);
        //runs the lsit method
        System.out.println("running list method. user input = " + response);
        Recursion.list(file);
        
        System.out.println("See terminal for results");

    }
    
}
