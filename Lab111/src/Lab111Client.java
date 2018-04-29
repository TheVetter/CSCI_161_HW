
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Andrew Vetter
 */
public class Lab111Client {

    public static void main(String[] args) {
        System.out.println("Start lab 111\n\n");
        //get file from user
        System.out.println("Please enter the absolute path to the file contaning the expression:");
        File file = new File(new Scanner(System.in).nextLine());

        SinglyLinkedList<String> wordsList = new SinglyLinkedList();

        try {
            Scanner fileScanner = new Scanner(file);
            //convert line to expression queue
            while (fileScanner.hasNext()) {
                //get read the file and input 
                String temp = fileScanner.next();
                if (temp != null) {
                    wordsList.addFirst(temp);
                }
            }
        } catch (Exception e) {
            System.out.println(" no file found");
        }
        String[] words = new String[wordsList.size()];

        for (int i = 0; i < wordsList.size(); i++) {
            words[i] = wordsList.removeFirst();
        }
        System.out.println("total words " + words.length);

        System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.printf("| Shift Amount | num of Colision | longest chain | Load Factor |\n");
        System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        SimpleHashTable table =new SimpleHashTable(words.length);
        for (int i = 0; i <= 16; i++) {
            table = new SimpleHashTable(words.length);
            table.setShift(i);

            for (String word : words) {
                if (word != null) {
                    table.put(word);
                }
            }
            System.out.printf("| %12d |    %12d |  %12d |   %f |\n", i, table.numCollisions(), table.longestChain(), table.loadFactor());
            System.out.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        }
        
        System.out.println("Runnning additional tests");
        try {
            String temp = table.get("TestWord");
        } catch (NullPointerException npe) {
            System.out.println(" get() returned null on a element that is not in the table");
        }
        try {
            String temp = table.remove("TestWord");
        } catch (NullPointerException npe) {
            System.out.println(" remove() returned null on a element that is not in the table");
        }
    }
}
