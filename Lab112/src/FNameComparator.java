/**
 *Compare a Students First Name in desending order 
 * @author Andrew Vetter
 */
public class FNameComparator implements Comparator<Student>{

    
    public int compare(Student a, Student b) {
        
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        String firstA = a.getfName();
        String firstB = b.getfName();
        
        return firstA.compareToIgnoreCase(firstB);
    
    }
    
}
