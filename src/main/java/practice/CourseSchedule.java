package practice;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    List<List<Integer>> graph = new LinkedList();

    public boolean dfs(int start, int[] visit) {
        if(visit[start] == 1)
            return false;
        visit[start] = 1;
        for(Integer dependency : graph.get(start)) {
            boolean res = dfs(dependency, visit);
            if(!res)
                return res;

        }
        visit[start] = 0;
        return true;
    }
    public boolean canFinish(int numberOfCourses, int[][] preRequisites) {

        for(int i = 0; i < numberOfCourses; i++) {
            graph.add(new LinkedList<>());
        }
        for(int i = 0; i < preRequisites.length; i++) {
            int u = preRequisites[i][0];
            int v = preRequisites[i][1];
            graph.get(u).add(v);
        }
        int[] visit = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++) {
            for(int j = 0; j < graph.size(); j++){
                visit[j] = 0;
            }
            boolean res = dfs(i, visit);
            if(!res)
                return res;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisits = {{1,0},{0,1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(5, prerequisits));
    }
}
