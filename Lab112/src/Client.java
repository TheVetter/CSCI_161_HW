/**
 *
 * @author vetter
 */
public class Client {
    
    public static void main(String[] args) {
        
        System.out.println("Lab112 is beginning!! \n\n");
        int size = 1000000;
        Student[] school = new Student[size];
        school = initStudents(school, size);
        
        
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.printf("|    sort              |      Size    |    Time   |\n");
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        long startTime = System.currentTimeMillis();
        sort.mergeSort(copyStudents(school), new IdComparator());
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| MergeSort            |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        
        startTime = System.currentTimeMillis();
        
        sort.quickSort(copyStudents(school), new GPAcomparator());
        
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| quickSort            |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        size = 100000;
        school = initStudents(school, size);
        
        startTime = System.currentTimeMillis();
        sort.simpleBubbleSort(copyStudents(school), new IdComparator());
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| Simple Bubblesort    |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        
        startTime = System.currentTimeMillis();
        sort.effcientBubbleSort(copyStudents(school), new IdComparatorDesending());
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| effcient bubble sort |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        
        startTime = System.currentTimeMillis();
        sort.insertionSort(copyStudents(school), new GPAcomparator());
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| insertionSort        |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
         
        
        startTime = System.currentTimeMillis();
        sort.selectionSort(copyStudents(school), new StandingsComparator());
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| selection Sort       |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        Comparator[] order = new Comparator[5];
        order[4] = new StandingsComparator();
        order[3] = new GPAcomparator();
        order[2] = new LNameComparator();
        order[1] = new FNameComparator();
        order[0] = new IdComparator();
        
        startTime = System.currentTimeMillis();
        sort.radixSort(copyStudents(school), order);
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.printf("| radix Sort           |  %,10d  |%10d |\n", size, timeElapsed);
        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        
        System.out.println("\nEnd of lab 112");
    }
    
    /**
     * initiallize students array
     * @param school 
     * @param size 
     * @return  
     */
    public static Student[] initStudents(Student[] school, int size){
        school = new Student[size];
        for (int i=0; i<school.length;i++) {
            school[i] = new Student();
        }
//        System.out.println("students init");
        return school;
    }
    
    /**
     *  my copy array method 
     * @param school
     * @return 
     */
    public static Student[] copyStudents(Student[] school){
        Student[] temp = initStudents(school, school.length);
        for(int i=0; i <temp.length; i++){
            temp[i] = school[i];
        }
        return temp;
    }
}
