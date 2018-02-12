import java.io.File;
import java.io.FileNotFoundException;


/**
 *A class the has 3 recusive functions 
 * @author Andrew Vetter
 */
public class Recursion {
    
    /**
     * a recurssive Harmonic method. 
     * sum of 1/n + 1/n-1.....+1/0; 
     * @param n
     * @return 
     */
    public static double harmonic(int n){
   
        if(n ==1){
            return 1;
        }
        else{
            return (double)(1.0/n) + harmonic(n-1);
        }
    
    }
    
    /**
     * sum an int array using isabeles method defined in the book
     * @param A int[]
     * @return 
     */
    public static int isabelTechnique(int[] A) throws ArraynotBase2{
        
        //first check if of base 2
        if(!isBase2(A.length)){
             throw new ArraynotBase2("The Array is not of base 2.");
        }
        
        int[] B =new int[A.length/2];

        
        //sum every 2 index and put in B
        for(int i =0; i<(A.length/2); i++){
            B[i] = (A[2*i] + A[2*i+1]);
        }
        
        //check the size of B (Base case)
        if(B.length == 1){
            return B[0];
        }       
        
        return isabelTechnique(B);
        
    }
    
    /**
     * lists all the folders, subfolders, and files in a directory
     * @param path 
     */
    public static void list(File path){
        System.out.println("\nstarting path recussion in folder" + path.getAbsoluteFile());
        
        //print everythign in a directroy
        if(path.isDirectory()){
            String[] itemsInFolder = path.list();
            
            for (int i =0; i<itemsInFolder.length; i++) {
                File test = new File(path + File.separator + itemsInFolder[i]);
                if(test.isDirectory()){
                    list(test);
                }else{
                    System.out.println(test.getAbsolutePath());
                }
            }
            
        }
        if(path.isFile()){
                System.out.println(path.getAbsolutePath());
        }
        
        
    }
    
    /**
     * tests if the array is base 2 
     * @param length
     * @return 
     */
    private static boolean isBase2(int length){
                
        int temp = 2;
        
        while (temp <= length){
            if (temp == length){ return true;}
            temp *= 2;
        }

        return false;
        
        
        
    }
    
    
}