package practice;

import java.util.*;
// Java program to implement in-built pair classes
class T {
    int a;
    int b;

    public T(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class Test {

    public static void main(String[] args) {
        Stack<T> stack = new Stack<>();
        stack.push(new T(2, 1));

        List<Integer> linkedList = new LinkedList<>();

        List<Integer> arrayList = new ArrayList<>();


        Queue<Integer> queue = new LinkedList<>();
        //


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(3);
        pq.add(1);
        pq.add(2);
        while (!pq.isEmpty())
            System.out.println("pq " + pq.poll());


        Deque<Integer> deque = new ArrayDeque<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        //remove put get
        map.put(1, map.getOrDefault(1, 0));
        for(int value : map.values()) {
            System.out.println(value);
        }
        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }



        Set<Integer> set = new TreeSet<>();
        //add remove


        Object[] pair = new Object[2];
        pair[0] = 1;
        pair[1] = "A";
        System.out.println((int)pair[0]);
        System.out.println((String)pair[1]);
    }
}
