///* IMPORTANT: Multiple classes and nested static classes are supported */
//
///*
// * uncomment this if you want to read input.
////imports for BufferedReader
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//*/
////import for Scanner and other utility classes
//import com.sun.tools.javac.util.Pair;
//
//import java.util.*;
//import java.util.practice.interviews.LinkedList;
//
//
//// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//
//class TestClass {
//    String data;
//    TestClass parent;
//    List<TestClass> children = new ArrayList<>();
//    boolean isLocked;
//    boolean isLockable;
//    String lockedBy;
//
//    TestClass(String data){
//        this.data = data;
//        isLocked = false;
//        isLockable = true;
//        parent = null;
//    }
//
//    public static boolean Lock(TestClass x, String uuid){
//        if(x.isLockable == false)
//            return false;
//
//        TestClass t = x;
//        boolean flag = false;
//
//        while (t != null){
//            if(t.isLocked == true){
//                flag = true;
//                break;
//            }
//            t = t.parent;
//        }
//        if(flag == true){
//            return false;
//        } else {
//            x.isLocked = true;
//            x.lockedBy = uuid;
//            t = x;
//            while( t != null){
//                t.isLockable = false;
//                t = t.parent;
//            }
//        }
//        return true;
//    }
//
//    public static boolean UnLock(TestClass x){
//        if(x.isLocked == false)
//            return false;
//        TestClass t = x;
//        x.isLocked = false;
//        while(t != null){
//            t.isLockable = true;
//            t = t.parent;
//        }
//        return true;
//    }
//
//    public static boolean isLockable(TestClass x, String uuid){
//        Queue<TestClass> queue = new practice.interviews.LinkedList<>();
//        queue.add(x);
//        while(!queue.isEmpty()){
//            TestClass t = queue.remove();
//            if(t.isLocked == true){
//                if(!t.lockedBy.equals(uuid)){
//                    return false;
//                }
//            }
//            queue.addAll(t.children);
//        }
//        return true;
//    }
//
//    public static void unlock(TestClass x){
//        Queue<TestClass> queue = new practice.interviews.LinkedList<>();
//        queue.add(x);
//        while(!queue.isEmpty()){
//            TestClass t = queue.remove();
//            UnLock(t);
//            queue.addAll(t.children);
//        }
//    }
//    public static boolean UpgradeLock(TestClass x, String uuid){
//        if(isLockable(x, uuid)){
//            unlock(x);
//            Lock(x, uuid);
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String args[] ) throws Exception {
//        /* Sample code to perform I/O:
//         * Use either of these methods for input
//
//        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();                // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
//        */
//        //Scanner
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int nary = s.nextInt();
//        int queries = s.nextInt();
//        ArrayList<String> arr = new ArrayList<>(n+1);
//        ArrayList<TestClass> arrNodes = new ArrayList<>(n+1);
//        s.nextLine();
//        arr.add("");
//        for(int i = 1; i <= n; i++){
//            String data = s.nextLine();
//            arr.add(i, data);
//        }
//        arrNodes.add(new TestClass(""));
//        arrNodes.add(1,new TestClass(arr.get(1)));
//        for(int i = 2; i <= n; i++){
//            TestClass tmpNode = new TestClass(arr.get(i));
//            tmpNode.parent = arrNodes.get(i/nary);
//            arrNodes.add(i, tmpNode);
//        }
//        for(int i = 1; i <= n; i++){
//            TestClass tmNode = arrNodes.get(i);
//            if(i*nary + nary - 1 < n+1)
//                tmNode.children = arrNodes.subList(i*nary, i*nary + nary);
//        }
//        // for(int i = 0; i < n; i++){
//        //     System.out.println(i + " " + arr.get(i));
//        // }
//        for(int i = 0; i < queries; i++){
//            int operation = s.nextInt();
//            String t = s.nextLine();
//            String[] tm = t.split(" ");
//            int dataToFind = arr.indexOf(tm[1]);
//            if(operation == 1){
//                System.out.println(Lock(arrNodes.get(dataToFind), tm[2]));
//            } else if(operation == 2){
//                System.out.println(UnLock(arrNodes.get(dataToFind)));
//            } else if (operation == 3){
//                System.out.println(UpgradeLock(arrNodes.get(dataToFind), tm[2]));
//            }
//        }
//
//
//        // Write your code here
//
//    }
//}
