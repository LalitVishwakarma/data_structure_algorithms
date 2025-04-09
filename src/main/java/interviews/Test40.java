//import javafx.util.Pair;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Test40 {
////
////    LRU cache
////
////    size = 2
////
////            cache.set(1,45) // Inserts 1 into cache
////            cache.set(2,67) // Inserts 2 into cache
////
////            cache.set(3,45) // Removes 1 and inserts 3
////
////            cache.get(2) // Cache hit
////
////            cache.set(4,123) // Removes 2 and inserts  4
////
////    //
////
////
////    1
////    2
////
////    map key, timestamp
////            map timestamp -> pair
//
//
//    LLNode head;
//    LLNode tail;
//    static int k;
//    static int count;
//    Map<Integer, Integer> map = new HashMap<>();
//    public static class LLNode {
//        Pair<Integer, Integer> data;
//        LLNode next;
//
//        LLNode(int key, int value){
//            this.data = new Pair<>(key, value);
//            next = null;
//        }
//
//    }
//
//
//
//    public static void insertNode(LLNode head, LLNode tail, int key, int value){
//        LLNode newNode = new LLNode(key, value);
//
//        tail.next = newNode;
//        map.put(key, value);
//        count++;
//        if (count > k){
//            LLNode nodeToDelete = head;
//            head = head.next;
//            map.remove(head.data.getKey());
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//
//
//    }
//}
