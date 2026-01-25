package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GreedyAlgorithms {

    private static class Job {
        int profit;
        int deadLine;

        public Job(int profit, int deadLine) {
            this.profit = profit;
            this.deadLine = deadLine;
        }
    }

    private int jobSequencing(List<Job> jobs) {
        jobs.sort((a, b) -> b.profit - a.profit);
        int maxDeadLine = 0;
        for(Job job : jobs){
            maxDeadLine = Math.max(job.deadLine , maxDeadLine);
        }
        int[] jobSequencing = new int[maxDeadLine];
        Arrays.fill(jobSequencing, 0);

        for (Job job : jobs) {
            if (jobSequencing[job.deadLine - 1] == 0) {
                jobSequencing[job.deadLine - 1] = job.profit;
            }
        }
        int maxProfit = 0;
        for (int i : jobSequencing)
            maxProfit += i;
        return maxProfit;
    }

    public static void main(String[] args) {
        GreedyAlgorithms greedyAlgorithms = new GreedyAlgorithms();

        List<Job> list = new ArrayList<>();
        list.add(new Job(90, 7));
        list.add(new Job(85, 2));
        list.add(new Job(75, 4));
        list.add(new Job(65, 3));
        list.add(new Job(45, 5));
        list.add(new Job(35, 5));
        list.add(new Job(25, 1));
        list.add(new Job(15, 1));
        list.add(new Job(15, 2));

        System.out.println(greedyAlgorithms.jobSequencing(list));

    }
}
