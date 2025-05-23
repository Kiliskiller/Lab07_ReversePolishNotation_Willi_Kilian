package scanner;

public class CharacterAnalysis {

    public static void main(String[] args){
        //getType('2');
    }

    public static int getType(char c){
        int e = c;
        System.out.println("Should be 50:"+ c);

            if((e < 58) && (e > 47)){ return 0;} // Ziffer
            if (e ==42 || e ==43 || e ==45 || e ==47 || e ==94){return 1;} // Operanden + - * / ^
            return -1; // unwichtiges Zeichen

    }
}
