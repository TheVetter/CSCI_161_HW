package lab108;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Andrew Vetter
 * @version 3/25/18
 */
public class Clientlab109 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Start lab 109\n\n");
        //get file from user
        System.out.println("Please enter the absolute path to the file contaning the expression:");
        File file = new File(new Scanner(System.in).nextLine());

        try {
            Scanner fileScanner = new Scanner(file);
            //convert line to expression queue
            while (fileScanner.hasNext()) {
                //get read the file and input 
                String test = fileScanner.nextLine();
                System.out.println("The expression: " + test);
                
                LinkedQueue<String> expressionInOrder = getInorderQueue(test);
                
                LinkedQueue postOrderQ ;
                //make postfix on the queue
                try {
                    postOrderQ = shuntingYard(expressionInOrder);
                } catch (IllegalArgumentException iae) {
                    System.out.println("\t\t= NOT valid\n\n");
                    continue;
                }
                //evaluate the queue
                System.out.printf("\tpostfix = %s\n", printQueue(postOrderQ));
                System.out.printf("\t\t=  %.2f\n",evaluteQueue(postOrderQ));
                
                //make is a tree
                LinkedBinaryTree<String> tree;
                try{
                    tree = buildTree(postOrderQ);
                    printTransversals(tree); 
                }catch(NullPointerException npe){
                    System.out.println("\t\t= NOT valid\n\n");
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(" enter a valid path to the file next time" + fnfe);
        }

        System.out.println("\nend of lab 109. I hope this is right!");
    }

    /**
     * build a binary tree from a postordered queue
     * @param postOrderQueue
     * @return 
     */
    public static LinkedBinaryTree buildTree(Queue<String> postOrderQueue) {
        LinkedStack<LinkedBinaryTree> treeStack = new LinkedStack<>();
        
        while(!postOrderQueue.isEmpty()){
            if(isNumber(postOrderQueue.first())){
                LinkedBinaryTree temp = new LinkedBinaryTree<>();
                temp.addRoot(postOrderQueue.dequeue());
                treeStack.push(temp);
            }
            else if(isOperator(postOrderQueue.first())){
                LinkedBinaryTree op = new LinkedBinaryTree();
                op.addRoot(postOrderQueue.dequeue());
                LinkedBinaryTree right = treeStack.pop();
                LinkedBinaryTree left = treeStack.pop();
                op.attach(op.root, left, right);
                treeStack.push(op);
            }
        }
        return treeStack.pop();
    }
    
    /**
     * converts the inorderq into postFixQ
     *
     * @param inorderQ
     * @return
     */
    public static LinkedQueue shuntingYard(Queue inorderQ) throws IllegalArgumentException {
        LinkedQueue<String> postOrderQ = new LinkedQueue<>();
        LinkedStack<String> stack = new LinkedStack<>();

        if(isOperator((String) inorderQ.first()) )
                throw new IllegalArgumentException("Malformed experssion");
            
        while (!inorderQ.isEmpty()) {
            
            if(inorderQ.size()==1 && isOperator((String) inorderQ.first()) )
                throw new IllegalArgumentException("Malformed experssion");
            String top = (String) inorderQ.dequeue();
            if (isNumber(top)) {
                postOrderQ.enqueue(top);
            } else if (isOperator(top)) {
                stack.push(top); //put the operator on the stack
            } else if (isGroupingSymbol(top)) {
                //test if left token
                if ("({[".contains(top)) {
                    stack.push(top); // put left grouper on stack
                } else if ("}])".contains(top)) { //test if right token
                    while (true) {
                        if(findGroupingPair(stack.peak(), top)){
                            stack.pop();
                            break;
                        }
                        postOrderQ.enqueue(stack.pop());
                        if(stack.isEmpty())//safety exit
                            throw new IllegalArgumentException("Malformed expression missing left grouper. Error 78");
                    }

                } else {
                    // should never reach but why not throw expecption
                    throw new IllegalArgumentException("invalid use of grouping symbols: error 0");
                }
            }
        }

        while (!stack.isEmpty()) {
            if(isGroupingSymbol(stack.peak()) || isNumber(stack.peak()))
                throw new IllegalArgumentException("Malformed experssion. Error 456");
            postOrderQ.enqueue(stack.pop());
        }

        return postOrderQ;
    }

    /**
     * tests if it's a number
     * @param num
     * @return
     */
    public static boolean isNumber(String num) {
        return num.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * tests if its an operator
     * @param op
     * @return
     */
    public static boolean isOperator(String op) {
        return "/*-+".contains(op);
    }

    /**Test if s is a grouping symbol
     * @param s
     * @return
     */
    public static boolean isGroupingSymbol(String s) {
        return "{}[]()".contains(s);
    }

    /**
     * takes a text file that has nts in it and converts to a int[]
     *
     * @param path
     * @return int[] from the file
     */
    private static LinkedQueue<String> getInorderQueue(String expression) {
        LinkedQueue result = new LinkedQueue<>();
        String[] bits = expression.split(" ");
        //parse the expression convert to q
        for (String bit : bits) {
            result.enqueue((String) bit);
        }

        return result;
    }

    /**
     * sees if the left and right are matching groupers 
     * @param leftGrouper
     * @param rightGrouper
     * @return
     * @throws IllegalArgumentException 
     */
    private static boolean findGroupingPair(String leftGrouper, String rightGrouper) throws IllegalArgumentException {

        switch (leftGrouper) {
            case "(":
                if (rightGrouper.equals(")")) {
                    return true;
                } else {
                    throw new IllegalArgumentException("miss match of grouping symbols. expected ')'.error 1");
                }

            case "{":
                if (rightGrouper.equals("}")) {
                    return true;
                } else {
                    throw new IllegalArgumentException("miss match of grouping symbols. expected '}'. error 2");
                }

            case "[":
                if (rightGrouper.equals("]")) {
                    return true;
                } else {
                    throw new IllegalArgumentException("miss match of grouping symbols. expected ']' error 3");
                }

            default:
                return false;
        }

    }
    
    /**
     * evaluates the queue and returns the result 
     * @param q
     * @return 
     */
    public static double evaluteQueue(LinkedQueue<String> q){
        LinkedQueue<String> stack = new LinkedQueue();
        for( int i=0;i<q.size();i++){
            String temp =  q.dequeue();
            stack.enqueue(temp);
            q.enqueue(temp);
        }        
        LinkedStack nums = new LinkedStack();
        double right;
        double left;
        
        if(stack.size() ==1)
            return Double.parseDouble(stack.dequeue());
        
        while(!stack.isEmpty()){
            while(true){
                if(isOperator(stack.first()))
                    break;
                nums.push(Double.parseDouble(stack.dequeue()));
            }
            switch(stack.dequeue()){
                case"+":
                    right =  (double)nums.pop();
                    left =  (double)nums.pop();
                    nums.push(left + right);
                    break;
                case"-":
                    right = (double)nums.pop();
                    left = (double)nums.pop();
                    nums.push(left - right);
                    break; 
                case"*":
                    right = (double)nums.pop();
                    left = (double)nums.pop();
                    nums.push(left * right);
                    break;
                case"/":
                    right = (double)nums.pop();
                    left = (double)nums.pop();
                    nums.push(left / right);
                    break;
                default: 
                    throw new IllegalArgumentException();
            }
        }
        return (double)nums.pop();
    }

    /**
     * prints a queue
     * @param q
     * @return 
     */
    private static String printQueue(Queue q) {
       String firstElement = (String)q.dequeue();
       String result = firstElement;
       q.enqueue(firstElement);
        while(q.first() != firstElement){
            result += q.first();
            q.enqueue(q.dequeue());// move to the end of the line
        }
        return result;
    }

    /**
     * print the transversals 
     * @param tree 
     */
    private static void printTransversals(LinkedBinaryTree<String> tree) {
        System.out.println("\nA preorder transversal of the tree");
        for(Position<String> p : tree.preorder())
            System.out.print(p.getElement( ));
        
        System.out.println("\nInorder transveral of the tree");
        for(Position<String> p : tree.inorder())
            System.out.print(p.getElement( ));
        
        System.out.println("\nPostorder transveral of the tree");
        for(Position<String> p : tree.postorder())
            System.out.print(p.getElement( ));
        System.out.println("\neulers tour transversal of the tree");
        for(Position<String> p : tree.eulersTour())
            System.out.print(p.getElement( ));
        System.out.println("\n\n");
         
       
    }

}