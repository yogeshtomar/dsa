package recursion.subsequencePattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatePowerSet {
    public static Set<String> getPowerSet(String str) {
        Set<String> powerSet = new HashSet<>();
        generateSubset(str, 0, "", powerSet);
        return powerSet;
    }

    private static void generateSubset(String str, int index, String current, Set<String> powerSet) {
        if (index == str.length()) {
            powerSet.add(current);
            return;
        }

        generateSubset(str, index+1, current, powerSet);
        generateSubset(str, index+1, current + str.charAt(index), powerSet);
    }

    public static void main(String[] args) {
        String input = "cab";
        Set<String> powerSet = getPowerSet(input);
        System.out.println("The power set of the input string : " + input + " is :" + powerSet);
    }
}
