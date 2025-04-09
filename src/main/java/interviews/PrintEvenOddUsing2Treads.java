package interviews;//public class PrintEvenOddUsing2Treads {
//
//    static int count = 1;
//    static int N = 10;
//    void printEvenNumber(){
//        synchronized (this) {
//            while (count < N){
//                while (count % 2 == 1){
//                    try {
//                        wait();
//                    } catch (InterruptedException e){
//                        System.out.println(e.getStackTrace());
//                    }
//                }
//                System.out.println(count + " ");
//                count++;
//                notify();
//            }
//        }
//    }
//
//    void printOddNumber(){
//        synchronized (this) {
//            while (count < N){
//                while (count % 2 == 0){
//                    try {
//                        wait();
//                    } catch (InterruptedException e){
//                        System.out.println(e.getStackTrace());
//                    }
//                }
//                System.out.println(count + " ");
//                count++;
//                notify();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        PrintEvenOddUsing2Treads o = new PrintEvenOddUsing2Treads();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                o.printOddNumber();
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                o.printEvenNumber();
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
//}


public class PrintEvenOddUsing2Treads extends Thread {

    public void printEven(int N) throws InterruptedException {
        synchronized (this){
            for (int i = 1; i <= N; i++){
                if (i % 2 == 1){
                    wait();
                } else {
                    System.out.println(i + "- " + Thread.currentThread().getName());
                    notify();
                }
            }
        }
    }

    public void printOdd(int N) throws InterruptedException {
        synchronized (this){
            for (int i = 1; i <= N; i++){
                if (i % 2 == 0){
                    wait();
                } else {
                    System.out.println(i + "- " + Thread.currentThread().getName());
                    notify();
                }
            }
        }
    }
    public static void main(String[] args) {
        PrintEvenOddUsing2Treads obj = new PrintEvenOddUsing2Treads();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printEven(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printOdd(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
