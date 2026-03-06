package leetcode.top_interview_questions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
 * bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * */
public class CourseScheduling {
    public boolean canCompleteAllCourses(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];

        Arrays.fill(inDegree, 0);

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for(int neightbour : graph.get(node)) {
                inDegree[neightbour]--;
                if (inDegree[neightbour] == 0)
                    queue.add(neightbour);
            }
        }
        return result.size() == numCourses;
    }

    public static void main(String[] args) {
        CourseScheduling courseScheduling = new CourseScheduling();

        int[][] prerequisites = {{1,0}};

        System.out.println(courseScheduling.canCompleteAllCourses(2, prerequisites));
    }
}
