package graphs.topologicalSort;

import java.util.*;

public class VerifyDictionary {

    public static boolean verifyAlienDictionary(String[] words, String order) {
        if (words.length == 1)
            return true;

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length())
                    return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (orderMap.get(words[i].charAt(j)) > orderMap.get(words[i + 1].charAt(j))) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }

        return true;
    }
    // Driver code
    public static void main(String[] args) {
        String[][] words = {
                {"alpha", "bravo", "charlie", "delta"},
                {"apple", "app"},
                {"martian"},
                {"jupyter", "ascending"},
                {"passengers", "to", "the", "unknown"}
        };
        String[] order = {
                "abcdefghijklmnopqrstuvwxyz",
                "abcdefghijklmnopqrstuvwxyz",
                "mabcdefghijklnopqrstuvwxyz",
                "jabcdefghiklmnopqrstuvwxyz",
                "ptuhabcdefghijklmnoqrsvwxyz"
        };
        for (int i = 0; i < order.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tWords : " + Arrays.toString(words[i]));
            System.out.print("\n\tOrder : " + order[i]);
            System.out.println("\n\tAlien Dictionary verified: " + verifyAlienDictionary(words[i], order[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}