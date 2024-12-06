package tries;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int prefixCount;
    int endingWithCount;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        endingWithCount = 0;
        prefixCount = 0;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void increseEnd() {
        endingWithCount++;
    }

    public void increasePrefix() {
        prefixCount++;
    }

    public void deleteEnd() {
        endingWithCount--;
    }

    public void reducePrefix() {
        prefixCount--;
    }
}
