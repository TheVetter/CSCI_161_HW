/**
 * Compare a Students id in desending order 
 * @author vetter
 */
public class IdComparatorDesending implements Comparator<Student>{
   
    @Override
    public int compare(Student a, Student b) {
    
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        int IdA = a.getId();
        int idB = b.getId();
        
        if ((IdA > idB ))
            return -1;
        else if ((IdA == idB))
            return 0;
        else if ((IdA < idB))
            return 1;
        else 
            throw new IllegalArgumentException(" stupid error");
    }
    
}
