package scanner;


import java.sql.SQLOutput;
import java.util.ArrayList;

public class myScanner {

    static boolean done;
    static int limitor;
    static String operator;

    static String input;
    public myScanner(String input){
        this.input = input.replaceAll("\\s+","");
    }

    public String[] getToken() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Character> cTok = new ArrayList<>();

        for (int i = 0; i<input.length();i++){
            cTok.add(input.charAt(i));
        }


        limitor = getLimitor();
        int k = 0;
        for (k = 0; k<cTok.size(); k++){

            if (isNumber(cTok.get(k))){
                boolean unfinished = true;
                String gesamt = "";
                int l = 1;
                while (unfinished) {


                    if (k==cTok.size()-l){
                        result.add(0,""+cTok.get(k));
                        unfinished = false;
                        break;
                    }
                    //nächstes Zeichen ist eine Nummer
                    else if (isNumber(cTok.get(k+l))){
                        gesamt += "" + cTok.get(k) + cTok.get(k+l);
                        l++;
                        result.add(0,gesamt);
                        unfinished = false;
                        if(k>3){
                        k--;}else{k++;}
                    } else {
                        gesamt = ""+cTok.get(k);
                        result.add(0,gesamt);
                        unfinished = false;
//                        k++;
                    }
                }
            }
            else if (isOperator(cTok.get(k))){
                operator = ""+ cTok.get(k);
                //result.add(2,""+cTok.get(k));
            }
        }

        result.add(2,operator);
        String[] allTokens = new String[result.size()];
        for (int j = 0; j<result.size(); j++){
            allTokens[j]=result.get(j);
        }
        return allTokens;
    }


    public static int getLimitor(){
        switch(input.length()){
            case 3: return 0;
            case 4: return 1;
            case 5: return 2;
        }
        return 0;
    }


//         for(int i = 0; i<input.length();i++){
//            if(isNumber(input.charAt(i)) && ){
//
//            }
//        }


    public static boolean isOperator(char e){
        if (e == 42 || e == 43 || e == 45 || e == 47 || e == 94){
            return true;
        } else {
            return false;
        }
    }






//    public String[] getToken() {
//        ArrayList<String> result = new ArrayList<>();
//        int i = 0;
//        done = false;
//        while(!done){
//
//            char e = input.charAt(i);
//            if (e == 42 || e == 43 || e == 45 || e == 47 || e == 94){
//                result.add(""+input.charAt(i));
//                if(i == input.length()-1){done=true;}
//                i++;
//            }
//
//            else if (isNumber(e)){
//                String multidigit = ""+e;
//                int counter = i-1;
//
//                if(counter == input.length()-1){
//                    done=true;
//                }else {
//                    while (isNumber(input.charAt(counter + 1))) {
//                        multidigit += "" + input.charAt(counter + 1);
//                        if(counter == input.length()-1){done=true;
//                        }else{
//                        counter++;
//                        }
//                    }
//                }
//
//                result.add(multidigit);
//                multidigit = "";
//                i=counter+1;
//            }
//        }
//        String[] allTokens = new String[result.size()];
//        for (int j = 0; j<result.size(); j++){
//            allTokens[j]=result.get(j);
//        }
//        return allTokens;
//    }


    private static boolean isNumber(char c) {
        if ((c < 58) && (c > 47)){
            return true;
        }else{return false;}
    }

}

