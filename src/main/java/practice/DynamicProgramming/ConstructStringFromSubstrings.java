package practice.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructStringFromSubstrings {

    static boolean canConstruct(String target, String[] wordBank) {
        if(target.isEmpty())
            return true;

        for(int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])) {
                if(canConstruct(target.substring(wordBank[i].length()), wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canConstructWithMemorisation(String target, String[] wordBank, Map<String, Boolean> map) {
        if(map.containsKey(target))
            return map.get(target);
        if(target.isEmpty())
            return true;

        for(int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])) {
                if(canConstructWithMemorisation(target.substring(wordBank[i].length()), wordBank, map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }

    static int countConstructWithMemorisation(String target, String[] wordBank, Map<String, Integer> map) {
        if(map.containsKey(target))
            return map.get(target);
        if(target.isEmpty())
            return 1;

        int count = 0;

        for (String s : wordBank) {
            if (target.startsWith(s)) {
                count += countConstructWithMemorisation(target.substring(s.length()), wordBank, map);
            }
        }

        map.put(target, count);
        return count;
    }

    static String[] howConstruct(String target, String[] wordBank) {
        if(target.isEmpty())
            return new String[0];

        for(int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])) {
                String[] res = howConstruct(target.substring(wordBank[i].length()), wordBank);
                if(res != null) {
                    String[] result = new String[res.length + 1];
                    result[0] = wordBank[i];
                    for(int j = 0; j < res.length; j++){
                        result[j+1] = res[j];
                    }

                    return result;
                }
            }
        }
        return null;
    }

    static String[] howConstructWithMemorisation(String target, String[] wordBank, Map<String, String[]> map) {
        if(map.containsKey(target))
            return map.get(target);
        if(target.isEmpty())
            return new String[0];

        for(int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])) {
                String[] res = howConstructWithMemorisation(target.substring(wordBank[i].length()), wordBank, map);
                if(res != null) {
                    String[] result = new String[res.length + 1];
                    result[0] = wordBank[i];
                    for(int j = 0; j < res.length; j++){
                        result[j+1] = res[j];
                    }
                    map.put(target, result);
                    return result;
                }
            }
        }
        map.put(target, null);
        return null;
    }

    static String[] bestConstruct(String target, String[] wordBank) {
        if(target.isEmpty())
            return new String[0];

        String[] bestResult = null;

        for(int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])) {
                String[] res = howConstruct(target.substring(wordBank[i].length()), wordBank);
                if(res != null) {
                    String[] result = new String[res.length + 1];
                    result[0] = wordBank[i];
                    for(int j = 0; j < res.length; j++){
                        result[j+1] = res[j];
                    }
                    if(bestResult == null || bestResult.length > result.length) {
                        bestResult = result;
                    }
                }
            }
        }
        return bestResult;
    }

    static String[][] allConstructWithMemorisation(String target, String[] wordBank, Map<String, String[][]> map) {
        if(map.containsKey(target))
            return map.get(target);
        if(target.isEmpty())
            return new String[0][0];

        String[][] allConstruct = null;

        for (int i = 0; i < wordBank.length; i++) {
            if(target.startsWith(wordBank[i])){
                String[][] res = allConstructWithMemorisation(target.substring(wordBank[i].length()), wordBank, map);
                if(res != null) {
                    String[][] result;
                    if(res.length == 0){
                        result = new String[1][1];
                        result[0][0] = wordBank[i];
                    } else {
                        result = new String[res.length][];
                        for(int k = 0; k < res.length; k++) {
                            result[k] = new String[res[k].length+1];
                            result[k][0] = wordBank[i];
                            for(int l = 0; l < res[k].length; l++){
                                result[k][l+1] = res[k][l];
                            }
                        }
                    }

                    if(allConstruct == null) {
                        allConstruct = result;
                    } else {
                        String[][] result1 = new String[allConstruct.length + result.length][];
                        System.arraycopy(allConstruct, 0, result1, 0, allConstruct.length);
                        System.arraycopy(result, 0, result1, allConstruct.length, result.length);
                        allConstruct = result1;
                    }
                }
            }
        }

        map.put(target, allConstruct);
        return allConstruct;
    }

    static String[][] allConstructWithTabulation(String target, String[] wordBank) {
        String[][][] table = new String[target.length() + 1][][];

        table[0] = new String[0][0];

        for(int i = 0; i < target.length(); i++) {
            for(int j = 0; j < wordBank.length; j++){
                if(target.substring(i).startsWith(wordBank[j])){
                    //get elements and add words
                    String[][] result = new String[table[i].length + 1][];
                    for(int k = 0; k < table[i].length; k++) {
                        result[k] = new String[table[i][k].length+1];
                        result[k][0] = wordBank[i];
                        for(int l = 0; l < table[i][k].length; l++){
                            result[k][l+1] = table[i][k][l];
                        }
                    }

                    //append solution at table index
                    String[][] result1 = new String[table[i + wordBank[j].length()].length + result.length][];
                    System.arraycopy(table[i + wordBank[j].length()], 0, result1, 0, table[i + wordBank[j].length()].length);
                    System.arraycopy(result, 0, result1, table[i + wordBank[j].length()].length, result.length);
                    table[i + wordBank[j].length()]= result1;
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args) {

        String target = "abcdef";
        String target2 = "skateboard";
        String target3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String target4 = "purple";

        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        String[] wordBank2 = {"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String[] wordBank3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        String[] wordBank4 = {"purp", "p", "ur", "le", "purpl"};
        String[] wordBank5 = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};

//        System.out.println(canConstruct(target, wordBank));
//        System.out.println(canConstruct(target2, wordBank2));
//
//        System.out.println(canConstructWithMemorisation(target, wordBank, new HashMap<String, Boolean>()));
//        System.out.println(canConstructWithMemorisation(target3, wordBank3, new HashMap<String, Boolean>()));
//
//        System.out.println(countConstructWithMemorisation(target4, wordBank4, new HashMap<String, Integer>()));
//        System.out.println(countConstructWithMemorisation(target, wordBank5, new HashMap<String, Integer>()));

//        System.out.println(Arrays.toString(howConstruct(target, wordBank)));

//        System.out.println(Arrays.toString(howConstructWithMemorisation(target, wordBank, new HashMap<String, String[]>())));
//        System.out.println(Arrays.toString(howConstructWithMemorisation(target2, wordBank2, new HashMap<String, String[]>())));
//        System.out.println(Arrays.toString(howConstructWithMemorisation(target3, wordBank3, new HashMap<String, String[]>())));
//
//        System.out.println(Arrays.toString(bestConstruct(target, wordBank)));
//        System.out.println(Arrays.toString(bestConstruct(target4, wordBank4)));

//        System.out.println(Arrays.deepToString(allConstructWithMemorisation(target, wordBank5, new HashMap<String, String[][]>())));
//        System.out.println(Arrays.deepToString(allConstructWithMemorisation(target4, wordBank4, new HashMap<String, String[][]>())));

//        System.out.println(Arrays.deepToString(allConstructWithTabulation(target, wordBank5)));
    }
}
