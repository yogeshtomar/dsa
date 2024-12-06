package tries;

public class LongestStringWIthAllThePrefixes {
    private TrieNode root;
    public LongestStringWIthAllThePrefixes() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }
            current = current.get(ch);
            current.increasePrefix();
        }
        current.increseEnd();
        current.isEndOfWord = true;
    }

    public boolean hasAllPrefixes(String word) {
        TrieNode node = root;
        for (char ch :word.toCharArray()) {
            node = node.children[ch-'a'];
            if (node == null || !node.isEndOfWord) {
                return false;
            }
        }
        return true;
    }

    public String longestWord(String[] words, LongestStringWIthAllThePrefixes trie) {
        for (String word : words) {
            trie.insert(word);
        }

        String longestWord = "";
        for (String word : words) {
            if (trie.hasAllPrefixes(word)) {
                if (word.length() > longestWord.length()
                || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        LongestStringWIthAllThePrefixes trie = new LongestStringWIthAllThePrefixes();
        String[] words = {"k", "ki", "kir", "kira", "kiran", "ke", "kel", "kelv", "kelvi"};
        System.out.println("Longest word with all prefixes: " + trie.longestWord(words, trie));
    }

}
