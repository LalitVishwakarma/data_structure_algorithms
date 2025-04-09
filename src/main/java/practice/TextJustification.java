package practice;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public String constructString(String[] words, int start, int end, int maxWidth) {
        int len = 0;
        String result = "";
        for(int i = start; i <= end; i++) {
            len += words[i].length();
        }
        int spacesToAdd = maxWidth - len;
        if(end == maxWidth) {
            for(int i = start; i <= end; i++)
                result += words[start] + " ";
            if(result.length() < maxWidth){
                int l = result.length();
                while (l < maxWidth) {
                    result += " ";
                    l++;
                }
            }
            return result;
        } else {
            int breaks = end - start;
            int space = spacesToAdd / breaks;
            int i = end;
            while(i > start) {
                result = words[i] + result;
                space = spacesToAdd / breaks;
                spacesToAdd -= space;
                breaks--;
                int s = 0;
                while(s < space) {
                    result = " " + result;
                    s++;
                }
                i--;
            }
        }

        return words[start] + result;
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        int width = 0;
        int start = 0;
        for(int i = 0; i < words.length; i++) {
            width += words[i].length();
            if(width >= maxWidth) {
                result.add(constructString(words, start, i - 1, maxWidth));
                start = i;
                width = words[i].length();
            }
            width++;
        }
        result.add(constructString(words, start, words.length - 1, maxWidth));
        return result;
    }

    public static void main(String[] args) {
        String a = "This is an example of text justification.";
        TextJustification textJustification = new TextJustification();
        List<String> result = textJustification.fullJustify(a.split(" "), 16);
        for (String s : result){
            System.out.println(s);
        }
    }
}
