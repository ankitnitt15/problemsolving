import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            TrieNode temp = current.getNode().get(word.charAt(i));
            if(temp == null){
                temp = new TrieNode();
                current.getNode().put(word.charAt(i), temp);
            }
            current = temp;
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            TrieNode temp = current.getNode().get(word.charAt(i));
            if(temp == null){
                return false;
            }
            current = temp;
        }
        return current.isEndOfWord();
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("World");
        System.out.println(trie.search("Hello"));
        System.out.println(trie.search("Worlds"));
    }

    class TrieNode{
        Map<Character, TrieNode> node;
        boolean endOfWord;

        public TrieNode(){
            node = new HashMap<>();
        }

        public Map<Character, TrieNode> getNode() {
            return node;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }



    }
}
