import java.util.Stack;

public class StackManipulation {
    public static void parse(Stack<String> st, String instruction) {
        Integer[] operands = new Integer[2];

        switch (instruction) {

            case "swap":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[0]));
                st.push(Integer.toString(operands[1]));
                break;
            case "dup":
                operands[0] = Stacker.pop_top_element(st);
                st.push(Integer.toString(operands[0]));
                st.push(Integer.toString(operands[0]));
                break;
            case "drop":
                if (!st.isEmpty()) {
                    st.pop();
                }
                break;
            case "over":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }
                st.push(Integer.toString(operands[1]));
                st.push(Integer.toString(operands[0]));
                st.push(Integer.toString(operands[1]));
                break;
            case "rot":
                if (StackManipulation.check_operands(st, operands) == false) {
                    break;
                }

                if (st.isEmpty()) {// we have two elements in the staack
                    st.push(Integer.toString(operands[0]));
                    st.push(Integer.toString(operands[1]));
                    break;
                }
                Integer op3 = Stacker.pop_top_element(st);
                st.push(Integer.toString(operands[0]));
                st.push(Integer.toString(operands[1]));
                st.push(Integer.toString(op3));
                break;
        }// end switch
    }

    static Boolean check_operands(Stack<String> st, Integer[] operand) {
        if (st.isEmpty()) {
            System.out.println("Stack is empty");
            return false;
        }
        operand[0] = Stacker.pop_top_element(st);

        if (st.isEmpty()) {
            System.out.println("Stack has only one element");
            st.push(Integer.toString(operand[0]));
            return false;
        }
        operand[1] = Stacker.pop_top_element(st);
        return true;
    }
}
