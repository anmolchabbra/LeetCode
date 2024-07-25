class TrieNode {
    TrieNode[] children = new TrieNode[26];
    public boolean isWord;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        // Initialize the class-level root variable
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println(c);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            System.out.println(curr);
        }
        curr.isWord = true;
    }

    private TrieNode searchIntial(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return null;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr;
    }

    public boolean search(String word) {
        TrieNode curr = searchIntial(word);
        if (curr == null) return false;
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = searchIntial(prefix);
        if (curr == null) return false;
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */