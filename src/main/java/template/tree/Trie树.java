package template.tree;

class Trie {
    class Node{
        boolean end;
        Node[] next;

        public Node(){
            end = false;
            next = new Node[26];
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordSeq = word.toCharArray();
        Node pos = root;
        for(char c : wordSeq){
            int idx = c - 'a';
            if(pos.next[idx] == null){
                pos.next[idx] = new Node();
            }
            pos = pos.next[idx];
        }
        pos.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordSeq = word.toCharArray();
        Node pos = root;
        for(char c : wordSeq){
            int idx = c - 'a';
            if(pos.next[idx] == null){
                return false;
            }
            pos = pos.next[idx];
        }
        return pos.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wordSeq = prefix.toCharArray();
        Node pos = root;
        for(char c : wordSeq){
            int idx = c - 'a';
            if(pos.next[idx] == null){
                return false;
            }
            pos = pos.next[idx];
        }
        return true;
    }
}

public class Trie树 {

}
