package lab108;

import java.util.ArrayList;

/**
 *
 * @author Andrew Vetter
 * @version 3/8/18
 */
public class ClientLab108 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Start lab 108");
        
        System.out.println("we will be now create this equation in a "
                + "linked binary tree: (((5+2)*(2-1)/(2+9)+((7-2)-1))* 8)");  
        //create the bottom branch
        LinkedBinaryTree<String> LBT1 = new LinkedBinaryTree<>();
        LBT1.addRoot("+");
        LBT1.addLeft(LBT1.root, "5");
        LBT1.addRight(LBT1.root, "2");
        
        LinkedBinaryTree<String> LBT2 = new LinkedBinaryTree<>();
        LBT2.addRoot("-");
        LBT2.addLeft(LBT2.root, "2");
        LBT2.addRight(LBT2.root, "1");
        
        LinkedBinaryTree<String> LBT3 = new LinkedBinaryTree<>();
        LBT3.addRoot("*");
        LBT3.attach(LBT3.root, LBT1, LBT2);
        
        LinkedBinaryTree<String> LBT4 = new LinkedBinaryTree<>();
        LBT4.addRoot("+");
        LBT4.addLeft(LBT4.root, "2");
        LBT4.addRight(LBT4.root, "9");
        
        LinkedBinaryTree<String> LBT5 = new LinkedBinaryTree<>();
        LBT5.addRoot("/");
        LBT5.attach(LBT5.root, LBT3, LBT4);
        
        LinkedBinaryTree<String> LBT6 = new LinkedBinaryTree<>();
        LBT6.addRoot("-");
        LBT6.addLeft(LBT6.root, "7");
        LBT6.addRight(LBT6.root, "2");
        
        LinkedBinaryTree<String> LBT8 = new LinkedBinaryTree<>();
        LBT8.addRoot("1");
        
        LinkedBinaryTree<String> LBT7 = new LinkedBinaryTree<>();
        LBT7.addRoot("-");
        LBT7.attach(LBT7.root, LBT7, LBT8);
        
        LinkedBinaryTree<String> LBT9 = new LinkedBinaryTree<>();
        LBT9.addRoot("+");
        LBT9.attach(LBT9.root, LBT5, LBT7);
        
        LinkedBinaryTree<String> LBT11 = new LinkedBinaryTree<>();
        LBT11.addRoot("8");        
        
        LinkedBinaryTree<String> LBT10 = new LinkedBinaryTree<>();
        LBT10.addRoot("*");
        LBT10.attach(LBT10.root, LBT9, LBT11);
        
        System.out.println("\n\nA preorder transversal of the tree");
        for(Position<String> p : LBT10.preorder())
            System.out.print(p.getElement( ));
        
        System.out.println("\n\n Inorder transveral of the tree");
        for(Position<String> p : LBT10.inorder())
            System.out.print(p.getElement( ));
        
        System.out.println("\n\n Postorder transveral of the tree");
        for(Position<String> p : LBT10.postorder())
            System.out.print(p.getElement( ));
         
        System.out.println("\n\n Breadth First transveral of the tree");
        for(Position<String> p : LBT10.breadthfirst())
            System.out.print(p.getElement( ));
        
        System.out.println("\n\n Breadth First transveral of the tree");
        for(Position<String> p : LBT10.breadthfirst())
            System.out.print(p.getElement( ));
            
        System.out.println("\n\nA preorder indent transversal of the tree");
        printPreorderIndent(LBT10, LBT10.root, 0);
        
        System.out.println("\n\nA parenthesized representation of the tree");
        parenthesize(LBT10, LBT10.root);
        
        System.out.println("\nend of lab 108. I hope this is right!");
    }
       
    
    
    /** Prints labeled representation of subtree of T rooted at p having depth d.
     * @param <E>
     * @param T
     * @param p
     * @param path
     */
    public static <E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
        int d = path.size( );
        // depth equals the length of the path
        System.out.print(spaces(2 * d));
        // print indentation, then label
        for (int j=0; j < d; j++) System.out.print(path.get(j) + (j == d-1 ? " " : "."));
        System.out.println(p.getElement( ));
        path.add(1);
        // add path entry for first child
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
            // increment last entry of path
        }
        path.remove(d);
        // restore path to its incoming state
    }

    private static String spaces(int i) {
        String temp = "";
        for(int c =0; c<i; c++)
            temp +=(" ");
        return temp; 
    }
    
    /** Returns total disk space for subtree of T rooted at p.
     * @param T
     * @param p
     * @return  */
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement( );
        // we assume element represents space usage
        for (Position<Integer> c : T.children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }
    /** Prints parenthesized representation of subtree of T rooted at p.
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void parenthesize(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement( ));
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : T.children(p)) {
                System.out.print( (firstTime ? " (" : ", ") ); // determine proper punctuation
                firstTime = false;
                // any future passes will get comma
                parenthesize(T, c);
                // recur on child
            }
            System.out.print(")");
        }
    }
    /** Prints preorder representation of subtree of T rooted at p having depth d. 
     */
    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement( ));
        // indent based on d
        for (Position<E> c : T.children(p))
            printPreorderIndent(T, c, d+1);
        // child depth is d+1
}
    
}
