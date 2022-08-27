
import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;
//import print in java
import java.lang.System;

public class Stacker {
    // main method
    public static void main(String[] args) {
        // create a stack
        Stack<String> stack = new Stack<String>();

        // getting an insttruction
        Scanner sc = new Scanner(System.in);
        System.out.println("Program Started");
        String raw_instruction;
        String[] instruction_array;

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
        } // end endless loop
          // how ironic xDDDDD

        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Program terminated");
        sc.close();

    }// end main

    private static void parser(Stack<String> st, String instruction) {
        Integer op1 = pop_top_element(st);
        Integer op2 = pop_top_element(st);

        switch (instruction) {
            case "add":
                st.push(Integer.toString(op1 + op2));
                break;
            case "sub":
                st.push(Integer.toString(op1 - op2));
                break;
            case "mul":
                st.push(Integer.toString(op1 * op2));
                break;
            case "div":
                st.push(Integer.toString(op2 / op1));
                break;
            case "mod":
                st.push(Integer.toString(op1 % op2));
                break;
            case "neg":
                st.push(Integer.toString(op2));
                st.push(Integer.toString(-op1));
                break;
            case "swap":
                st.push(Integer.toString(op1));
                st.push(Integer.toString(op2));
                break;
            case "dup":
                st.push(Integer.toString(op1));
                st.push(Integer.toString(op1));
                break;
            case "drop":
                st.push(Integer.toString(op2));
                break;
            case "over":
                restore_stack(st, op1, op2);
                st.push(Integer.toString(op2));
                break;
            case "rot":
                int op3 = pop_top_element(st);
                st.push(Integer.toString(op1));
                st.push(Integer.toString(op2));
                st.push(Integer.toString(op3));
                break;
            case "print":
                restore_stack(st, op1, op2);
                System.out.println(op1);
                break;
            case "printall":
                restore_stack(st, op1, op2);
                System.out.println(Arrays.toString(st.toArray()));
                break;
            case "clear":
                st.clear();
                break;
            case "size":
                restore_stack(st, op1, op2);
                System.out.println(st.size());
                break;
            case "help":
                restore_stack(st, op1, op2);
                display_help();
                break;
            case "exit":
                System.out.println("Program terminated");
                System.exit(0);
                break;

            default:
                restore_stack(st, op1, op2);
                System.out.println("Invalid instruction");
                break;

        }// end switch
        if (!st.isEmpty()) {
            System.out.println("Top of stack > " + st.peek());
        }

    }

    private static Integer pop_top_element(Stack<String> st) {
        if (!st.isEmpty()) {
            return Integer.parseInt(st.pop());
        } else {
            return null;
        }
    }

    private static void restore_stack(Stack<String> st, Integer op1, Integer op2) {
        if (op2 != null)
            st.push(Integer.toString(op2));
        if (op1 != null)
            st.push(Integer.toString(op1));

    }

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
