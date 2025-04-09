package Challange500;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] result = new char[s.length()];
        int totalDefferent = (numRows * 2) - 2;
        int halfPoint = totalDefferent / 2;
        for(int i = 0; i < s.length(); i++) {
            int devide = i / totalDefferent;
            int a = i % totalDefferent;
            if(a <= halfPoint) {

                result[(devide * totalDefferent) + a] = s.charAt(i);
            } else {
                result[(devide * totalDefferent) + totalDefferent - a] = s.charAt(i);
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
//        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
        String[] a = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int sum = a.length - 1;
        for(int i = 0; i < a.length; i++) {
            sum += a[i].length();
        }
        System.out.println(sum);



    }
}