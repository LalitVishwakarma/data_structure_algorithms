package interviews;

public class ThreadEvenOdd {
    static int COUNT = 0;

    public void printEven() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 11; i += 2) {
                if (COUNT % 2 != 0) {
                    wait();
                } else {
                    System.out.println(i);
                    COUNT++;
                    notify();
                }
            }
        }
    }

    public void printOdd() throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i < 11; i += 2) {
                if (COUNT % 2 == 0) {
                    wait();
                } else {
                    System.out.println(i);
                    COUNT++;
                    notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadEvenOdd object = new ThreadEvenOdd();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    object.printEven();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    object.printOdd();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }
        });

        t1.start();
        t2.start();
    }
}
