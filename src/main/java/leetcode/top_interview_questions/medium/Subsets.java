package leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public void subsets(int index, int[] nums, boolean[] visit, List<Integer> path, List<List<Integer>> solution) {
        if(path.size() <= nums.length) {
            solution.add(new ArrayList(path));

            for(int i = index; i < nums.length; i++) {
                if(visit[i] == false) {
                    visit[i] = true;
                    path.add(nums[i]);
                    subsets(i + 1, nums, visit, path, solution);
                    path.remove(path.size() - 1);
                    visit[i] = false;
                }
            }
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] visit = new boolean[nums.length];
        Arrays.fill(visit, false);
        subsets(0, nums, visit, new ArrayList(), result);
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] ints = {1,2,3};
        List<List<Integer>> result = subsets.subsets(ints);
        result.forEach(element -> {
            element.forEach(System.out::print);
            System.out.println();
        });
    }
}
