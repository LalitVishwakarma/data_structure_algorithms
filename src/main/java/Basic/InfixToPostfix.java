package Basic;

import java.util.Stack;

public class InfixToPostfix {

    public int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < postfix.length()) {
            if(isOperand(postfix.charAt(i))) {
                stack.push(postfix.charAt(i) - '0');
            } else {
                stack.push(performOperation(stack.pop(), stack.pop(), postfix.charAt(i)));

            }
            i++;
        }
        return stack.pop();
    }

    private Integer performOperation(Integer b, Integer a, char c) {
        return switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> (int) Math.pow(a, b);
            default -> 0;
        };
    }

    public String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < infix.length()) {
            if(isOperand(infix.charAt(i))) {
                result.append(infix.charAt(i));
            } else {
                while (!stack.isEmpty() && precedence(infix.charAt(i)) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(infix.charAt(i));
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    private boolean isOperand(char c) {
        return c != '+' && c != '-' && c != '*' && c != '/' && c != '^';
    }

    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println(infixToPostfix.convert("a+b*c-d/e"));
        System.out.println(infixToPostfix.evaluate("32*5+62/-"));
        System.out.println(infixToPostfix.evaluate("623+-382/+*2^3+"));
    }
}
