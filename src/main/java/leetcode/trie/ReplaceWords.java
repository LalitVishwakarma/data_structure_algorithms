package leetcode.trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
        class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> childrenMap = new HashMap();
        }

        TrieNode root;

        public void insert(String word) {
            System.out.println("insert - " + word);
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                curr.childrenMap.putIfAbsent(c, new TrieNode());
                curr = curr.childrenMap.get(c);
            }
            curr.isWord = true;
        }

        public String replace(String word) {
            StringBuilder s = new StringBuilder();
            System.out.println("replace - " + word);
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if(curr.isWord){
                    return s.toString();
                }
                if(curr.childrenMap.get(c) == null) {
                    return word;
                }
                s.append(c);
                curr = curr.childrenMap.get(c);
            }
            return word;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            root = new TrieNode();
            for(String word : dictionary) {
                insert(word);
            }
            String[] sentenceArray = sentence.split(" ");
            for(int i = 0; i < sentenceArray.length; i++) {
                sentenceArray[i] = replace(sentenceArray[i]);
            }

            return String.join(" ", sentenceArray);
        }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        String result = replaceWords.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery");
        System.out.println(result);
    }
}
