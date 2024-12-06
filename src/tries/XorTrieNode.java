package tries;

public class XorTrieNode {
    XorTrieNode[] links;
    public XorTrieNode() {
        links = new XorTrieNode[2];
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    XorTrieNode get(int bit) {
        return links[bit];
    }

    void put(int bit, XorTrieNode node) {
        links[bit] = node;
    }
}
