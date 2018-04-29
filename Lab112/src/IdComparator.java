/**
 * A student ID comparator for sorting them in ascending order
 * @author vetter
 */
public class IdComparator implements Comparator<Student>{
   
    @Override
    public int compare(Student a, Student b) {
    
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        int IdA = a.getId();
        int idB = b.getId();
        
        if ((IdA > idB ))
            return 1;
        else if ((IdA == idB))
            return 0;
        else if ((IdA < idB))
            return -1;
        else 
            throw new IllegalArgumentException(" stupid error");
    }
    
}
