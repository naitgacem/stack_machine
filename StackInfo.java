import java.util.Arrays;
import java.util.Stack;

public class StackInfo {
    public static void parse(Stack<String> st, String instruction) {
        switch (instruction) {
            case "printall":
                System.out.println(Arrays.toString(st.toArray()));
                break;
            case "clear":
                st.clear();
                break;
            case "size":
                System.out.println(st.size());
                break;
            case "help":
                display_help();
                break;
        }
    }// end parse

    private static void display_help() {
        System.out.println("push <number> : push a number to the stack");
        System.out.println("add : add the top two numbers on the stack");
        System.out.println("sub : subtract the top two numbers on the stack");
        System.out.println("mul : multiply the top two numbers on the stack");
        System.out.println("div : divide the top two numbers on the stack");
        System.out.println("mod : get the remainder of the top two numbers on the stack");
        System.out.println("neg : negate the top number on the stack");
        System.out.println("swap : swap the top two numbers on the stack");
        System.out.println("dup : duplicate the top number on the stack");
        System.out.println("drop : drop the top number on the stack");
        System.out.println("over : copy the second number on the stack to the top");
        System.out.println("rot : rotate the top three numbers on the stack");
        System.out.println("print : print the top number on the stack");
        System.out.println("printall : print all the numbers on the stack");
        System.out.println("clear : clear the stack");
        System.out.println("size : print the size of the stack");
        System.out.println("help : print this help message");
        System.out.println("exit | halt : exit the program");
    }
}
