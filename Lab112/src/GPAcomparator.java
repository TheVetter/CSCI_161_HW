/**
 * Compare a Students GPA in desending order 
 * @author vetter
 */
public class GPAcomparator implements Comparator<Student>{

    
    public int compare(Student a, Student b) {
    
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        double gpaA = a.getGpa();
        double gpaB = b.getGpa();
        
        if ((Math.abs(gpaA-gpaB) >= 0.001) )
            return 1;
        else if ((Math.abs(gpaA-gpaB)) <= 0.001)
            return 0;
        else if (Math.abs(gpaB-gpaA) >= .001)
            return -1;
        else 
            throw new IllegalArgumentException(" stupid error");
    }
    
    
}
