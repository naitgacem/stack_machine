
import java.util.Stack;
import java.util.Scanner;
//import print in java
import java.lang.System;

//import Arithmetic;

public class Stacker {
    // main method
    public static void main(String[] args) {
        // create a stack
        Stack<String> stack = new Stack<String>();

        // getting an insttruction
        Scanner sc = new Scanner(System.in);

        // Arithmetic.parse();

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

        System.out.println("Program terminated");
        sc.close();

    }// end main

    private static void parser(Stack<String> st, String instruction) {
        Integer op1 = 0;// pop_top_element(st);
        Integer op2 = 0; // pop_top_element(st);

        switch (instruction) {
            case "add":
            case "sub":
            case "mul":
            case "div":
            case "mod":
            case "neg":
                Arithmetic.parse(st, instruction);
                break;

            case "swap":
            case "rot":
            case "dup":
            case "drop":
            case "over":
                StackManipulation.parse(st, instruction);
                break;

            case "printall":
            case "clear":
            case "size":
            case "help":
                StackInfo.parse(st, instruction);
                break;

            case "exit":
                System.out.println("Program terminated");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid instruction");
                break;

        }// end switch
        if (!st.isEmpty()) {
            System.out.println("Top of stack > " + st.peek());
        }

    }

    public static Integer pop_top_element(Stack<String> st) {
        if (!st.isEmpty()) {
            return Integer.parseInt(st.pop());
        } else {
            return null;
        }
    }

}
