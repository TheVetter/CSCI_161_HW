/** A standings comparator for the Student class.
 *
 * @author Andrew Vetter
 */
public class StandingsComparator implements Comparator<Student>{

    @Override
    public int compare(Student a, Student b) {
        if ( a == null || b == null )  
        {
            throw new NullPointerException();
        }
        
        switch(a.getStanding()){
            case "Senior":
                switch(b.getStanding()){
                    case "Senior": return  0;
                    case "junior": return -1;
                    case "sophmore": return -1;
                    case "freshman": return -1;
                    default:
                        throw new IllegalArgumentException();
                }
            case "junior":
                switch(b.getStanding()){
                    case "Senior": return  1;
                    case "junior": return 0;
                    case "sophmore": return -1;
                    case "freshman": return -1;
                    default:
                        throw new IllegalArgumentException();
                }
            case "sophmore":
                switch(b.getStanding()){
                    case "Senior": return  1;
                    case "junior": return 1;
                    case "sophmore": return 0;
                    case "freshman": return -1;
                    default:
                        throw new IllegalArgumentException();
                }
            case "freshman":
                switch(b.getStanding()){
                    case "Senior": return  1;
                    case "junior": return 1;
                    case "sophmore": return 1;
                    case "freshman": return 0;
                    default:
                        throw new IllegalArgumentException();
                }
                default:
                    throw new IllegalArgumentException();
                    
        }
    }
    
}
