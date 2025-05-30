package scanner;

import postfix.Infix;
import postfix.Postfix;
import stack.Underflow;

import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.setOut;
import static postfix.Infix.toPostfix;
import static postfix.Postfix.evaluate;


public class UI_exe {

    static boolean success;

    public static void main(String[] args) throws Underflow {
        getType();
    }

    public static int getType() throws Underflow {
        Scanner scanner = new Scanner(System.in);
        out.println("\nSchreib' hier die Terme hinein, die du berechnet haben willst.\nDein Input sollte das Format -Zahl Operation Zahl- haben, dabei dürfen die Zahlen bis zu zweistellig sein.");
        while (true) {
            try {
                String myString = scanner.nextLine();
                if (myString.length() > 2) {
                   String[] tokens = new myScanner(myString).getToken();

//                   String formula = "";
//                    for (int i = 0; i < tokens.length; i++) {
//                        if (tokens[i] != null) {
//                            //System.out.println(tokens[i]);
//                            formula += tokens[i];
//                        }
//                    }
                    // tokens überführen

                    out.println("Result: " + evaluate(tokens));

                }else{
                    out.println("This is not a valid input.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
