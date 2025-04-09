//import java.util.ArrayList;
//import java.util.List;
//
//public class SevenTon extends Thread {
//
//    int data;
//
//    public void produce(int a){
//        data = a;
//        notify();
//    }
//    public int consume(){
//        return data;
//        notify();
//    }
//
//    public static void main(String[] args) {
//
//        SevenTon seventon = new SevenTon();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 10; i++){
//                    System.out.println("producing " + i);
//                    seventon.produce(i);
//                    wait();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 10; i++){
//                    int c = seventon.consume();
//                    System.out.println("consumed " + c);
//                    wait();
//                }
//            }
//        });
//    }
//}
