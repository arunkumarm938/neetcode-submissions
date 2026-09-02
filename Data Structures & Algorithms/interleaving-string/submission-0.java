public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        return dfs(0, 0, 0, s1, s2, s3, new HashMap<Integer, Map<Integer, Boolean>>());
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3, Map<Integer, Map<Integer, Boolean>> memo) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }
        if(memo.containsKey(i) && memo.get(i).containsKey(j)){
            return memo.get(i).get(j);
        }
        boolean res1 = false;
        boolean res2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res1 = dfs(i + 1, j, k + 1, s1, s2, s3, memo);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res2 = dfs(i, j + 1, k + 1, s1, s2, s3, memo);
        }
        memo.putIfAbsent(i, new HashMap<Integer, Boolean>());
        memo.get(i).put(j, res1 || res2);
        return res1 || res2;
    }
}