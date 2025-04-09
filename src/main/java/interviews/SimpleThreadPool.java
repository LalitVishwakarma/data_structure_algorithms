package interviews;

import java.util.LinkedList;

public class SimpleThreadPool {

    private WorkerThreads[] threads;
    private LinkedList<Runnable> taskQueue;

    SimpleThreadPool(int noOfThreads){
        taskQueue = new LinkedList<>();
        threads = new WorkerThreads[noOfThreads];

        for(int i = 0; i < noOfThreads; i++){
            threads[i] = new WorkerThreads();
            threads[i].start();
        }
    }

    public void enqueueTask(Runnable r){
        synchronized (taskQueue) {
            taskQueue.addLast(r);
            taskQueue.notify();
        }
    }
    public class WorkerThreads extends Thread {

        public void run(){
            Runnable r;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()){
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = taskQueue.removeFirst();
                }
                try {
                    r.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

