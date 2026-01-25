package Basic;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    boolean isEndOfWord;
    Map<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
    }
}

public class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String input) {

        TrieNode temp = root;
        for (char c : input.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                TrieNode newNode = new TrieNode();
                temp.children.put(c, newNode);
            }
            temp = temp.children.get(c);
        }
        temp.isEndOfWord = true;

    }
    public boolean search(String input) {
        TrieNode temp = root;
        for (char c : input.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String input) {
        TrieNode temp = root;
        for (char c : input.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("care");

        System.out.println(trie.search("cat"));      // true
        System.out.println(trie.search("cap"));      // false
        System.out.println(trie.startsWith("ca"));   // true
        System.out.println(trie.startsWith("dog"));  // false
    }

}
