package practice.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSumFromNumbers {

    static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int i = 0; i < numbers.length; i++) {
            if (canSum(targetSum - numbers[i], numbers)) {
                return true;
            }
        }
        return false;
    }

    static boolean canSumWithMemorisation(int targetSum, int[] numbers, Map<Integer, Boolean> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int i = 0; i < numbers.length; i++) {
            if (canSumWithMemorisation(targetSum - numbers[i], numbers, map)) {
                map.put(targetSum, true);
                return true;
            }
        }

        map.put(targetSum, false);
        return false;
    }

//    static boolean canSumWithTabulation(int targetSum, int[] numbers) {
//        boolean[] table = new boolean[targetSum + 1];
//        for (int i = 0; i < table.length; i++)
//            table[i] = false;
//        table[0] = true;
//        for (int i = 0; i <= targetSum; i++) {
//            if (table[i]) {
//                for (int j = 0; j < numbers.length; j++) {
//                    if (i + numbers[j] < table.length)
//                        table[i + numbers[j]] = true;
//                }
//            }
//        }
//        return table[targetSum];
//    }

    static int[] howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new int[0];
        if (targetSum < 0) return null;

        for (int j = 0; j < numbers.length; j++) {
            int[] res = howSum(targetSum - numbers[j], numbers);
            if (res != null) {
                int[] result = new int[res.length + 1];
                result[0] = numbers[j];
                for (int i = 0; i < res.length; i++)
                    result[i + 1] = res[i];
                return result;
            }
        }
        return null;
    }

    static int[] howSumWithMemorisation(int targetSum, int[] numbers, Map<Integer, int[]> map) {
        if (map.containsKey(targetSum))
            return map.get(targetSum);
        if (targetSum == 0) return new int[0];
        if (targetSum < 0) return null;

        for (int j = 0; j < numbers.length; j++) {
            int[] res = howSumWithMemorisation(targetSum - numbers[j], numbers, map);
            if (res != null) {
                int[] result = new int[res.length + 1];
                result[0] = numbers[j];
                for (int i = 0; i < res.length; i++)
                    result[i + 1] = res[i];
                map.put(targetSum, result);
                return result;
            }
        }
        map.put(targetSum, null);
        return null;
    }

//    static int[] howSumWithTabulation(int targetSum, int[] numbers) {
//        int[][] table = new int[targetSum + 1][targetSum];
//        for (int i = 0; i <= targetSum; i++) table[i] = null;
//        table[0] = new int[0];
//
//        for (int i = 0; i <= targetSum; i++) {
//            if (table[i] != null) {
//                for (int j = 0; j < numbers.length; j++) {
//                    if(i + numbers[j] <= targetSum) {
//                        int[] result = new int[table[i].length + 1];
//                        result[0] = numbers[j];
//                        for (int k = 0; k < table[i].length; k++)
//                            result[k + 1] = table[i][k];
//                        table[i + numbers[j]] = result;
//                    }
//                }
//            }
//        }
//
//        return table[targetSum];
//    }

    static int[] bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new int[0];
        if(targetSum < 0) return null;

        int[] result = null;

        for(int i = 0; i < numbers.length; i++){
            int[] res = bestSum(targetSum - numbers[i], numbers);
            if(res != null) {
                if(result == null || res.length + 1 < result.length) {
                    int[] temp = new int[res.length + 1];
                    temp[0] = numbers[i];
                    for (int k = 0; k < res.length; k++)
                        temp[k + 1] = res[k];
                    result = temp;
                }
            }
        }
        return result;
    }

    static int[] bestSumWithMemorisation(int targetSum, int[] numbers, Map<Integer, int[]> map) {
        if(map.containsKey(targetSum))
            return map.get(targetSum);
        if (targetSum == 0) return new int[0];
        if(targetSum < 0) return null;

        int[] result = null;

        for(int i = 0; i < numbers.length; i++){
            int[] res = bestSumWithMemorisation(targetSum - numbers[i], numbers, map);
            if(res != null) {
                if(result == null || res.length + 1 < result.length) {
                    int[] temp = new int[res.length + 1];
                    temp[0] = numbers[i];
                    for (int k = 0; k < res.length; k++)
                        temp[k + 1] = res[k];
                    result = temp;
                }
            }
        }
        map.put(targetSum, result);
        return result;
    }

    static int[] bestSumWithTabulation(int targetSum, int[] numbers) {
        int[][] table = new int[targetSum + 1][targetSum];
        for (int i = 0; i <= targetSum; i++) table[i] = null;
        table[0] = new int[0];

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int j = 0; j < numbers.length; j++) {
                    if(i + numbers[j] <= targetSum) {

                        int[] result = new int[table[i].length + 1];
                        result[0] = numbers[j];
                        for (int k = 0; k < table[i].length; k++)
                            result[k + 1] = table[i][k];

                        if(table[i + numbers[j]] == null || table[i + numbers[j]].length > result.length)
                            table[i + numbers[j]] = result;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 4, 7};
        int[] numbers2 = {7, 14};
        int[] numbers3 = {2, 4};
        int[] numbers4 = {2, 3};
        int[] numbers5 = {1, 2, 5, 25};
        System.out.println(canSum(7, numbers));
        System.out.println(canSum(300, numbers2));

        System.out.println(canSumWithMemorisation(7, numbers, new HashMap<Integer, Boolean>()));
        System.out.println(canSumWithMemorisation(300, numbers2, new HashMap<Integer, Boolean>()));
//
//        System.out.println(canSumWithTabulation(7, numbers));
//        System.out.println(canSumWithTabulation(300, numbers2));

        System.out.println(Arrays.toString(howSum(7, numbers)));
        System.out.println(Arrays.toString(howSum(7, numbers3)));

        System.out.println(Arrays.toString(howSumWithMemorisation(7, numbers, new HashMap<Integer, int[]>())));
        System.out.println(Arrays.toString(howSumWithMemorisation(300, numbers2, new HashMap<Integer, int[]>())));

//        System.out.println(Arrays.toString(howSumWithTabulation(7, numbers4)));
//        System.out.println(Arrays.toString(howSumWithTabulation(100, numbers5)));

        System.out.println(Arrays.toString(bestSum(7, numbers)));

        System.out.println(Arrays.toString(bestSumWithMemorisation(100, numbers5, new HashMap<Integer, int[]>())));

        System.out.println(Arrays.toString(bestSumWithTabulation(100, numbers5)));
    }
}
