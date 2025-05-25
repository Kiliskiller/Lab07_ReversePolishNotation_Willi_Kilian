package scanner;


import java.util.ArrayList;

public class myScanner {

    static boolean done;

    String input;
    public myScanner(String input){
        this.input = input.replaceAll("\\s+","");
    }

    public String[] getToken() {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        done = false;
        while(!done){

            char e = input.charAt(i);
            if (e == 42 || e == 43 || e == 45 || e == 47 || e == 94){
                result.add(""+input.charAt(i));
                if(i == input.length()-1){done=true;}
                i++;
            }

            else if (isNumber(e)){
                String multidigit = ""+e;
                int counter = i;

                if(counter == input.length()-1){
                    done=true;
                }else {
                    while (isNumber(input.charAt(counter + 1))) {
                        multidigit += "" + input.charAt(counter + 1);
                        counter++;
                    }
                }

                result.add(multidigit);
                multidigit = "";
                i=counter+1;
            }
        }
        String[] allTokens = new String[result.size()];
        for (int j = 0; j<result.size(); j++){
            allTokens[j]=result.get(j);
        }
        return allTokens;
    }


    private boolean isNumber(char c) {
        if ((c < 58) && (c > 47)){
            return true;
        }else{return false;}
    }

}

