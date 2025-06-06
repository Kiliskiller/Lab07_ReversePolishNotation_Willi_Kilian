package postfix;

import stack.Underflow;


import static stack.Stack.Stack;

public class Infix {

    public static void main(String[] args) throws Underflow {
//        System.out.println("Should be 42: " + Postfix.evaluate((toPostfix("7 * 6"))));
//        System.out.println("Should be 20: " + Postfix.evaluate("5 4 *"));
//        System.out.println("Should be 2.25: " + Postfix.evaluate("9 4 /"));
//        System.out.println(toPostfix("1 + 2"));
//        System.out.println(toPostfix("3 - 4"));
//        System.out.println(toPostfix("6 * 7"));
//        System.out.println(toPostfix("8 / 4"));
    }

    public static String[] toPostfix(String[] tokens) {
        //LinkedList<Object> Stack = new LinkedList<>();

                String infix = "";
                    for (int i = 0; i < tokens.length; i++) {
                        if (tokens[i] != null) {
                            //System.out.println(tokens[i]);
                            infix += tokens[i];
                        }
                    }

            // pushing all the operands on the stack
            for (int j = 0; j < infix.length(); j++) {
                int e = infix.charAt(j);
                if (e ==42 || e ==43 || e ==45 || e ==47 || e ==94){
                    Stack.push(infix.charAt(j));}
            }
            // pushing all the numbers on to the stack
            for (int j = 0; j < infix.length(); j++) {
                int e = infix.charAt(j);
                if ((e < 58) && (e > 47)){
                Stack.push(infix.charAt(j));}
            }

        String[] output = new String[3];

        //while (!Stack.isEmpty()){
            String second = ""+Stack.pop();
            String first = ""+Stack.pop();

            output[0] = first;
            output[1] = second;
            output[2] = ""+Stack.pop();

//            output = ""+first+" "+second + " " + Stack.pop();

        //}

        return output;
    }
}