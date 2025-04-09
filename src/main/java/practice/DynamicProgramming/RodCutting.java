package practice.DynamicProgramming;

public class RodCutting {

    static int rodCuttingWithTabulation(int[] values, int rodLength) {
        if (rodLength <= 0) return 0;

        int max_val = Integer.MIN_VALUE;

        for (int i = 0; i < rodLength; i++) {
            max_val = Math.max(max_val, values[i] + rodCuttingWithTabulation(values, rodLength - i - 1));
        }
        return max_val;
    }

    static int rodCuttingWithMemorisation(int[] value, int rodLength) {
        if(rodLength <= 0)
            return 0;

        int max_val= Integer.MIN_VALUE;

        for(int i = 0; i < rodLength; i++) {
            int result = value[i] + rodCuttingWithMemorisation(value, rodLength-i-1);
            if(result > max_val)
                max_val = result;
        }

        return max_val;
    }

    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return "";
        }
        System.out.println(at);
        System.out.println(str1.charAt(at));
        return str1.substring(at);
    }

    public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return -1;
        }
        if (cs1 == null || cs2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                break;
            }
        }
        if (i < cs2.length() || i < cs1.length()) {
            return i;
        }
        return -1;
    }


    public static void main(String[] args) {

//        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
//        int size = arr.length;
//        System.out.println("Maximum Obtainable Value is "+
//                rodCuttingWithMemorisation(arr, size));

        String a = "this is a example";
        String b = "this is a examp";

        System.out.println(difference(a, b));

    }
}
