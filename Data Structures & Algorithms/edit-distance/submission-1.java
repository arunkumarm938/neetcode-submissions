class Solution {
    public int minDistance(String word1, String word2) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return dfs(0,0, word1, word2, memo);
    }
    private int dfs(int i, int j, String word1, String word2, Map<Integer, Map<Integer, Integer>> memo){
        if(i == word1.length()){
            return  (word2.length() - j);
        }
        if(j == word2.length()){
            return  (word1.length() - i);
        }
        if(memo.containsKey(i) && memo.get(i).containsKey(j)){
            return memo.get(i).get(j);
        }
        int r = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            r = dfs(i+1,j+1,word1, word2, memo);
        }else{
            int res = Math.min(dfs(i + 1, j, word1, word2, memo),
                           dfs(i, j + 1, word1, word2, memo));
            res = Math.min(res, dfs(i + 1, j + 1, word1, word2, memo));
            r = res + 1;
        }
        memo.putIfAbsent(i, new HashMap<Integer, Integer>());
        memo.get(i).put(j, r);
        return r;
    }
}
