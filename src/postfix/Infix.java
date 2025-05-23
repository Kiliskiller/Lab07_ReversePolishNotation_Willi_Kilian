package postfix;


import static stack.Stack.Stack;

public class Infix {

    public static void main(String[] args){
        System.out.println(toPostfix("1 + 2"));
        System.out.println(toPostfix("3 - 4"));
        System.out.println(toPostfix("6 * 7"));
        System.out.println(toPostfix("8 / 4"));
    }

    public static String toPostfix(String infix) {
        //LinkedList<Object> Stack = new LinkedList<>();

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

        String output = "";

        //while (!Stack.isEmpty()){
            char second = (char) Stack.pop();
            char first = (char) Stack.pop();
            output = ""+first+" "+second + " " + Stack.pop();
        //}

        return output;
    }
}





/*

// this method is a good template for the scanner class -> 2d Array with hints for is it a number or an operator

 Object[][] cache = {{0,1,2},
                        {     }};


switch (CharacterAnalysis.getType(infix.charAt(i))) {
int l = 0;
                // Ziffer
                case 0:
                        cache[l][infix.charAt(i)] = infix.charAt(i);
                        System.out.println("Added "+infix.charAt(i)+" to cache as num");
                        l++;

                // Operand
                case 1:
                        cache[l][infix.charAt(i)] = infix.charAt(i);
                        System.out.println("Added "+infix.charAt(i)+" to cache as operand");
                        l++;
                // unwichtiges Zeichen
                case -1:
                }
 */