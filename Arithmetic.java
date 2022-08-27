import java.util.Stack;

public class Arithmetic {
    public static void parse(Stack<String> st, String instruction) {
        Integer[] operands = new Integer[2];

        switch (instruction) {
            case "add":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[0] + operands[1]));
                break;
            case "sub":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[0] - operands[1]));
                break;
            case "mul":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[0] * operands[1]));
                break;
            case "div":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[1] / operands[0]));
                break;
            case "mod":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[0] % operands[1]));
                break;
            case "neg":
                if (st.isEmpty()) {
                    System.out.println("Stack is empty");
                    break;
                }
                operands[0] = Stacker.pop_top_element(st);
                st.push(Integer.toString(-operands[0]));
                break;
        }// end switch
    }// end parse

}