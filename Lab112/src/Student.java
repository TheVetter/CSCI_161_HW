
import java.util.Random;

/** a Student that will generate it's random GPA, Standing, name, and ID
 *
 * @author Andrew Vetter
 */
public class Student {
    private final String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G","H", "I", "J","K","L","M","N", "O", "P" ,"Q", "R", "S", "T", "U", "V", "W", "X", "Y","Z"};
    
    
    private int id;
    private static boolean ids[] = new boolean[1000000];
    private String lName;
    private String fName;
    private String standing;
    private float gpa;

    public Student() {
        genID();
        genNames();
        genGPA();
        genStanding();       
    }
    
    /**
     * assigns a random id to this instance
     */
    private void genID(){
        Random r = new Random();
        int temp = r.nextInt(ids.length);
        while(ids[temp]){
            temp = r.nextInt(ids.length);
        }
        this.id = temp;
    }
    
    /**
     * assigns a random name to lname and fname
     */
    private void genNames(){
        Random l = new Random();
        int bound = l.nextInt(5)+10;
        for(int i =0; i< bound; i++){
            if(lName == null){
                lName += letters[l.nextInt(letters.length)];
            }else{
                lName += letters[l.nextInt(letters.length)].toLowerCase();
            }
        }
        
        bound = l.nextInt(5)+5;
        for(int i =0; i< bound; i++){
            if(lName == null){
                fName += letters[l.nextInt(letters.length)];
            }else{
                fName += letters[l.nextInt(letters.length)].toLowerCase();
            }
        }
        
    }
    
    /**
     * generate a gpa value for the student
     */
    private void genGPA(){
        Random r = new Random();
        int w = r.nextInt(20);
        float g = r.nextFloat();
      
            if(w == 0)
                gpa = 4;
            else if(w > 0 && w < 5)
                gpa = g + 3;
            else if(w > 4 && w <16) 
                gpa = 2 +g;
            else if(w > 15 && w < 19)
                gpa = 1 +g;
            else 
                gpa = g;
    }
    
    /**
     * generate standing for student 
     */
    private void genStanding(){
        Random r = new Random();
        int s = r.nextInt(10);
        switch (s) {
            case 0:
                standing = "Senior";
                break;
            case 1:
            case 2:
                standing = "junior";
                break;
            case 3:
            case 4:
            case 5:
                standing = "sophmore";
                break;
            default:
                standing = "freshman";
                break;
        }
    }
    
    public int getId() {
        return id;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }


    public String getStanding() {
        return standing;
    }


    public float getGpa() {
        return gpa;
    }


}
