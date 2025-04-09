package interviews;

public class PrintEvenOdd extends Thread {

    public void printEven(int n) throws InterruptedException {
        synchronized (this){
            for(int i  = 1; i <= n; i++) {
                if(i % 2 == 1){
                    wait();
                } else {
                    System.out.println(i + "  " + Thread.currentThread().getName());
                    notify();
                }
            }
        }
    }

    public void printOdd(int n) throws InterruptedException {
        synchronized (this){
            for (int i = 1; i <= n; i++){
                if(i % 2 == 0){
                    wait();
                } else {
                    System.out.println(i + "  " + Thread.currentThread().getName());
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintEvenOdd object = new PrintEvenOdd();

        Thread t1 = new Thread(() -> {
                try {
                    object.printEven(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });

        Thread t2 = new Thread(() -> {
            try {
                object.printOdd(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
