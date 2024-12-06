package tries;

public class DistinctSubstrings {
    private static TrieNode root;
    public DistinctSubstrings() {
        root = new TrieNode();
    }
    public int countDistinctSubstrings(String word) {
        int count = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(word.charAt(j))){
                    node.put(word.charAt(j), new TrieNode());
                    count++;
                }
                node = node.get(word.charAt(j));
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String s = "striver";
        // Input string
        System.out.println("Current String: " + s);
        DistinctSubstrings sol = new DistinctSubstrings();
        System.out.println("Number of distinct substrings: " + sol.countDistinctSubstrings(s));
        // Output the result
    }
}
