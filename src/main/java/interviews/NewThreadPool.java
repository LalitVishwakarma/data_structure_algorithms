package interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewThreadPool {

    int numberOfThreads;
    List<WorkerThread> threads;
    LinkedList<Runnable> tasks;

    public NewThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;

        threads = new ArrayList<>(numberOfThreads);

        for(int i = 0;i < numberOfThreads; i++){
            WorkerThread t = new WorkerThread();
            threads.add(t);
            t.start();
        }
        tasks = new LinkedList<>();
    }

    public void addTask(Runnable r){
        synchronized (this) {
            tasks.addLast(r); ;
            tasks.notify();
        }
    }

    private class WorkerThread extends Thread {

        @Override
        public void run() {
            Runnable r;
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = tasks.removeFirst();
                }

                r.run();
            }
        }
    }
}
