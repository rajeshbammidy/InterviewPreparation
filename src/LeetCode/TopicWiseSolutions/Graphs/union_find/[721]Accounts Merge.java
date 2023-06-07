package LeetCode.TopicWiseSolutions.Graphs.union_find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the elements
 * are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some common email to both accounts. Note that even
 * if two accounts have the same name, they may belong to different people as people
 * could have the same name. A person can have any number of accounts initially,
 * but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],[
 * "John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John",
 * "johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"]
 * ,["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email
 * "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses
 * are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 *
 *
 * Example 2:
 *
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
 * "Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
 * "Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.
 * co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.
 * co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"]
 * ,["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1
 *
 * @m.co","Fern5@m.co"]] Constraints:
 *
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 *
 *
 * Related Topics Array String Depth-First Search Breadth-First Search Union Find
 * 👍 5218 👎 899
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution721 {
    /**
     * The idea is to create adjacencyMap using the emailIds and we have to perform the DFS on it to find the
     * individual connected components.
     *
     * The adjacencyMap looks like the below:
     * {johnnybravo@mail.com=[], johnsmith@mail.com=[john_newyork@mail.com, john00@mail.com], john00@mail.com=[johnsmith@mail.com], john_newyork@mail.com=[johnsmith@mail.com], mary@mail.com=[]}
     */
    private HashMap<String, ArrayList<String>> adjacencyMap;
    private HashSet<String> visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        adjacencyMap = new HashMap<>();
        visited = new HashSet<>();
        for (List<String> account : accounts) {
            buildAdjacencyMap(account);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);
            if (!visited.contains(email)) {
                dfs(email, temp);
                temp.sort(null);
                List<String> sortedList = new ArrayList<>();
                sortedList.add(name);
                sortedList.addAll(temp);
                result.add(sortedList);
                temp.clear();
            }
        }
        return result;


    }

    private void dfs(String email, List<String> temp) {
        visited.add(email);
        temp.add(email);
        for (String nextEmail : adjacencyMap.get(email)) {
            if (!visited.contains(nextEmail))
                dfs(nextEmail, temp);
        }
    }

    private void buildAdjacencyMap(List<String> account) {
        for (int i = 1; i < account.size(); i++) {
            String current = account.get(i);
            String next = (i + 1) < account.size() ? account.get(i + 1) : null;
            if (adjacencyMap.get(current) == null) {
                adjacencyMap.put(current, new ArrayList<>());
            }
            if (next != null)
                adjacencyMap.get(current).add(next);
            if (next != null && adjacencyMap.get(next) == null) {
                adjacencyMap.put(next, new ArrayList<>());
                adjacencyMap.get(next).add(current);
            } else if (adjacencyMap.get(next) != null) {
                adjacencyMap.get(next).add(current);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
