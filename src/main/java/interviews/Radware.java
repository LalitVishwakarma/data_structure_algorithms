package interviews;

import java.util.Stack;

public class Radware {


    static String checkBalanced(String input){


        Stack<Character> stack = new Stack<>();
        int index = 0;

        while(index < input.length()){
            if(input.charAt(index) == '[' || input.charAt(index) == '{' || input.charAt(index) == '('){
                stack.push(input.charAt(index));
            } else {
                if(stack.isEmpty()){
                    return "unbalanced";
                } else {
                    char popedElement = stack.pop();
                    if(popedElement == '(' && input.charAt(index) != ')'){
                        return "unbalanced";
                    }
                    else if(popedElement == '{' && input.charAt(index) != '}'){
                        return "unbalanced";
                    }
                    else if(popedElement == '[' && input.charAt(index) != ']'){
                        return "unbalanced";
                    }
                }

            }
            index++;
        }
        if(stack.isEmpty()){
            return "balanced";
        }
        return "unbalanced";
    }

    public static void main(String[] args) {

        String input = "";

        System.out.println(checkBalanced(input));
    }
}
