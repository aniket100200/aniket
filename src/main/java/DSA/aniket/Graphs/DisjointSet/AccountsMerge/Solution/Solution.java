package DSA.aniket.Graphs.DisjointSet.AccountsMerge.Solution;

import DSA.aniket.Graphs.DisjointSet.AccountsMerge.AccountsMerge;
import DSA.aniket.Graphs.DisjointSet.DisjointSet;
import DSA.aniket.Graphs.DisjointSet.UnionBySize.UnionBySize;

import java.util.*;

public class Solution implements AccountsMerge {

    /**
     * @param accounts
     * @return
     */
    @Override
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet set = new UnionBySize(n);
        Map<String, Integer> emailToNodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToNodeMap.containsKey(email)) {
                    set.union(emailToNodeMap.get(email), i);
                } else {
                    emailToNodeMap.put(email, i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        /**
         * merging mails
         */
        for (String key : emailToNodeMap.keySet()) {
            int node = emailToNodeMap.get(key);
            int ultimateParent = set.findParent(node);
            mergedMail[ultimateParent].add(key);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> currentNodeList = mergedMail[i];
            if (!currentNodeList.isEmpty()) {
                Collections.sort(currentNodeList);
                var name = accounts.get(i).get(0);
                currentNodeList.add(0, name);
                ans.add(currentNodeList);
            }
        }


        return ans;
    }
}