
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
                op1 = Integer.parseInt(stack.pop());
                op2 = Integer.parseInt(stack.pop());

                if (instruction_array[0].equals("add")) {
                    stack.push(Integer.toString(op1 + op2));
                    System.out.println("> " + stack.peek());
                } else if (instruction_array[0].equals("sub")) {
                    stack.push(Integer.toString(op1 - op2));
                    System.out.println("> " + stack.peek());
                } else if (instruction_array[0].equals("mul")) {
                    stack.push(Integer.toString(op1 * op2));
                    System.out.println("> " + stack.peek());
                } else if (instruction_array[0].equals("div")) {
                    stack.push(Integer.toString(op1 / op2));
                    System.out.println("> " + stack.peek());
                } else if (instruction_array[0].equals("mod")) {
                    stack.push(Integer.toString(op1 % op2));
                    System.out.println("> " + stack.peek());
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Program terminated");
        sc.close();

    }

}
