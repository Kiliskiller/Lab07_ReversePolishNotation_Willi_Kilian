package scanner;

public class CharacterAnalysis {

    public static void main(String[] args){
        checkTypeOfChar('2');
    }

    public static int checkTypeOfChar(char c){
        int e = c;
        System.out.println("Should be 50:"+e);

            if((e < 58) && (e > 47)){ return 0;} // Ziffer
            if (e==42 || e==43 || e==45 || e==47 || e==94){return 1;} // Operand
            return -1;

    }
}
