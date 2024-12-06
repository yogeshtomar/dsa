package tries;

public class TrieEnhanced {
    private TrieNode root;
    public TrieEnhanced() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
            node.increasePrefix();
        }
        node.increseEnd();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            }
            else {
                return 0;
            }
        }
        return node.endingWithCount;
    }

    public int countWordsStartingWithPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            }
            else {
                return 0;
            }
        }
        return node.prefixCount;
    }

    public void delete(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)){
                node = node.get(ch);
                node.reducePrefix();
            }
            else {
                return;
            }
        }
        node.deleteEnd();
    }

    public static void main(String[] args) {
        TrieEnhanced trie = new TrieEnhanced();
        System.out.println("Inserting Strings 'apple' and 'app' into Trie");
        trie.insert("apple");
        trie.insert("app");
        System.out.println("words equal to apple :" + trie.countWordsEqualTo("apple"));
        System.out.println("no of words starting with 'app' : " + trie.countWordsStartingWithPrefix("app"));
        System.out.println("deleting word 'app' from the trie");
        trie.delete("app");
        System.out.println("count of words equal to 'apple' :" + trie.countWordsEqualTo("apple"));
        System.out.println("count of words starting with 'app' : " + trie.countWordsStartingWithPrefix("app"));
    }
}
