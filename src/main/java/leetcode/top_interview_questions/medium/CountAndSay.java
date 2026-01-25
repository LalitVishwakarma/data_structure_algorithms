package leetcode.top_interview_questions.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";

        for(int i = 2; i <= n; i++) {

            StringBuilder s = new StringBuilder();

            int j = 1;
            int count = 1;

            while(j < result.length()) {
                if(result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    s.append(count);
                    s.append(result.charAt(j - 1));
                    count = 1;
                }
                j++;
            }
            s.append(count);
            s.append(result.charAt(result.length() - 1));
            result = s.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();

        System.out.println(countAndSay.countAndSay(4));
    }
}
