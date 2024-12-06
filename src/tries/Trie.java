package tries;

public class Trie {
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index  = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }
    private boolean delete(TrieNode current, String word, int depth) {
        if (current == null) {
            return false;
        }
        if (depth == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return isNodeEmpty(current);
        }
        int index = word.charAt(depth) - 'a';
        TrieNode node = current.children[index];
        if (delete(node, word, depth+1)) {
            current.children[index] = null;
            return !current.isEndOfWord && isNodeEmpty(current);
        }
        return false;
    }
    private boolean isNodeEmpty(TrieNode node) {
        for (TrieNode child: node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apxl");
        trie.insert("bac");
        trie.insert("bat");

        System.out.println("search for 'apps' : " + trie.search("apps"));
        System.out.println("search for 'apple' : " + trie.search("apple"));
        System.out.println("search for 'bat' : " + trie.search("bat"));
        System.out.println("search for 'batman' : " + trie.search("batman"));
        System.out.println("deleting 'apps'");
        trie.delete("apps");
        System.out.println("search for 'apps' after deleting 'apps' : " + trie.search("apps"));
    }
}
