class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(
            0,
            0,
            s,
            p,
            new HashMap<Integer, Map<Integer, Boolean>>()
        );
    }

    private boolean dfs(
        int i,
        int j,
        String s,
        String p,
        Map<Integer, Map<Integer, Boolean>> memo
    ) {

        if (j == p.length()) {
            return i == s.length();
        }

        if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
            return memo.get(i).get(j);
        }

        boolean match =
            i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean res;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Don't use current char at all
            boolean skip = dfs(i, j + 2, s, p, memo);

            // Use current char once and stay at same pattern position
            boolean use = match && dfs(i + 1, j, s, p, memo);

            res = skip || use;

        } else {

            res = match && dfs(i + 1, j + 1, s, p, memo);
        }

        memo.putIfAbsent(i, new HashMap<Integer, Boolean>());
        memo.get(i).put(j, res);

        return res;
    }
}