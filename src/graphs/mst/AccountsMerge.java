package graphs.mst;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> owners = new HashMap<>();
        for (int i = 0; i < owners.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!owners.containsKey(email)) {
                    uf.unionBySize(i, owners.get(email));
                }
                else {
                    owners.put(email, i);
                }
            }
        }
        Map<Integer, TreeSet<String>> users = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int parent = uf.findParent(i);
            List<String> emails = accounts.get(i);
            users.putIfAbsent(parent, new TreeSet<>());
            users.get(parent).addAll(emails.subList(1, emails.size()));
        }

        List<List<String>> result = new ArrayList<>();
        for (int index : users.keySet()) {
            String name = accounts.get(index).get(0);
            List<String> emails = new LinkedList<>(users.get(index));
            emails.addFirst(name);
            result.add(emails);
        }
        return  result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>>  ans = accountsMerge.accountsMerge(accounts);
        int n = ans.size();
        for (List<String> an : ans) {
            System.out.print(an.getFirst() + ": ");
            int size = an.size();
            for (int j = 1; j < size; j++) {
                System.out.print(an.get(j) + " ");
            }

            System.out.println();
        }



    }
}
