/**
 * Last name comparator for the student class 
 * @author Andrew Vetter
 */
public class LNameComparator implements Comparator<Student>{

    
    public int compare(Student a, Student b) {
        
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        String lastA = a.getlName();
        String lastB = b.getlName();
        
        return lastA.compareToIgnoreCase(lastA);
    
    }
    
}
