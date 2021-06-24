import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created on 24/Jun/2021 to Valid-Parentheses
 */
public class ValidParentheses {

    static boolean isValid(String s){

        Deque<Character> stackDeque = new ArrayDeque<Character>();

        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);

            if(x == '(' || x == '[' || x == '{'){
                stackDeque.push(x);
                continue;
            }

            if(stackDeque.isEmpty()){
                return false;
            }

            char check;

            switch(x){
                case ')':
                    check = stackDeque.pop();
                    if(check == '{' || check == ']'){
                        return false;
                    }
                    break;
                case '}':
                    check = stackDeque.pop();
                    if(check == '(' || check == '['){
                        return false;
                    }
                    break;
                case ']':
                    check = stackDeque.pop();
                    if(check == '(' || check == '{'){
                        return false;
                    }
                    break;
            }//switch
        }//for

        return stackDeque.isEmpty();
    }//isValid

    public static void main(String args[]){
        String s = "{()}";
        if(isValid(s)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
