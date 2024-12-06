package Strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Char {
    char ch;
    int count;
    Char(char ch, int count) {
        this.count = count;
        this.ch = ch;
    }
}

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Queue<Char> queue = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.ch - b.ch: b.count - a.count));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Char(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Char current = queue.poll();
            while (current.count > 0) {
                sb.append(current.ch);
                current.count--;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tuee";
        System.out.println("s = " + s);
        String output = frequencySort(s);
        System.out.println(output);
    }
}
