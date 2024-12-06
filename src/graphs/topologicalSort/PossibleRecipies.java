package graphs.topologicalSort;

import java.util.*;

public class PossibleRecipies {
    public static List<String> findAllRecipes (String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>());
                List<String> ingList = graph.get(ing);
                ingList.add(recipes[i]);
                graph.put(ing, ingList);
                inDegree.put(recipes[i], inDegree.getOrDefault(recipes[i], 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));

        while (!queue.isEmpty()) {
            String ing = queue.poll();
            List<String> ings = graph.get(ing);
            if (ings != null) {
                for (String recipe : graph.get(ing)) {
                    inDegree.put(recipe, inDegree.get(recipe)-1);
                    if (inDegree.get(recipe) == 0) {
                        queue.add(recipe);
                    }
                }    
            }
        }

        for (String recipe : recipes) {
            if (inDegree.get(recipe) == 0) {
                result.add(recipe);
            }
        }

        return result;
    }
}
