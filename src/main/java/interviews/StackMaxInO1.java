//package practice.interviews;
//
//import javafx.util.Pair;
//
//import java.util.Stack;
//
//public class StackMaxInO1 {
//
//    static Stack<Integer> s = new Stack<>();
//    static Stack<Pair<Integer, Integer>> s2 = new Stack<>();
//
//    static int max() {
//        return s2.peek().getKey();
//    }
//
//    static void push(int value){
//        if(s2.isEmpty()){
//            s2.push( new Pair<>(value, 1));
//        } else if(value > s2.peek().getKey()){
//            s2.push( new Pair<>(value, 1));
//        } else if(value == s2.peek().getKey()){
//            Pair<Integer, Integer> tmp = s2.pop();
//            s2.push(new Pair<>(tmp.getKey(), tmp.getValue() + 1));
//        }
//        s.push(value);
//    }
//
//    static int pop() {
//        int value = s.pop();
//        if(value == s2.peek().getKey()){
//            Pair<Integer, Integer> tmp = s2.pop();
//            if(tmp.getValue() > 1){
//                s2.push(new Pair<>(tmp.getKey(), tmp.getValue() - 1));
//            }
//        }
//        return value;
//    }
//
//    public static void main(String[] args) {
//        push(1);
//        push(2);
//        push(3);
//        push(2);
//        push(3);
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        push(2);
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//
//
//    }
//}
