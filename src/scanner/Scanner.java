package scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;

public class Scanner {

    String input;
    public Scanner(String input){
        this.input = input;
    }

    public String[] getToken() {
        String[] result = new String[input.length()];
        for(int i = 0; i < input.length(); i++){
            result[i]=""+input.charAt(i);
        }
        return result;
    }

    }

