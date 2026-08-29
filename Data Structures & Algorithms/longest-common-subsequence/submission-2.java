class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return dfs(0, 0, text1, text2, memo);
    }

    private int dfs(
        int i,
        int j,
        String text1,
        String text2,
        Map<Integer, Map<Integer, Integer>> memo
    ) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
            return memo.get(i).get(j);
        }

        int result;

        if (text1.charAt(i) == text2.charAt(j)) {
            result = 1 + dfs(i + 1, j + 1, text1, text2, memo);
        } else {
            result = Math.max(
                dfs(i + 1, j, text1, text2, memo),
                dfs(i, j + 1, text1, text2, memo)
            );
        }

        memo.putIfAbsent(i, new HashMap<>());
        memo.get(i).put(j, result);

        return result;
    }
}