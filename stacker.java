
import java.util.Stack;
import java.util.Scanner;
//import print in java
import java.lang.System;

public class stacker {
    // main method
    public static void main(String[] args) {
        // create a stack
        Stack<String> stack = new Stack<String>();

        // getting an insttruction
        Scanner sc = new Scanner(System.in);
        System.out.println("Program Started");
        String raw_instruction;
        String[] instruction_array;
        int op1, op2;
        while (true) {
            System.out.print(">  ");
            raw_instruction = sc.nextLine();
            instruction_array = raw_instruction.split("\\s+");
            // push the instruction to the stack
            if (instruction_array[0].equals("halt")) {

                break;
            }
            if (instruction_array[0].contains("push")) {
                stack.push(instruction_array[1]);
            } else {
                parser(stack, instruction_array[0]);
            }
        } // end wireless loop

        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Program terminated");
        sc.close();

    }// end main

    private static void parser(Stack<String> st, String instruction) {
        int op1, op2;
        op1 = Integer.parseInt(st.pop());
        op2 = Integer.parseInt(st.pop());
        if (instruction.equals("add")) {
            st.push(Integer.toString(op1 + op2));
            System.out.println("> " + st.peek());

        } else if (instruction.equals("sub")) {
            st.push(Integer.toString(op1 - op2));
            System.out.println("> " + st.peek());

        } else if (instruction.equals("mul")) {
            st.push(Integer.toString(op1 * op2));
            System.out.println("> " + st.peek());

        } else if (instruction.equals("div")) {
            st.push(Integer.toString(op1 / op2));
            System.out.println("> " + st.peek());

        } else if (instruction.equals("mod")) {
            st.push(Integer.toString(op1 % op2));
            System.out.println("> " + st.peek());
        }

    }

}
