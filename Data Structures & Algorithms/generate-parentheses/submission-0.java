class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, res, new String());
        return res;
    }
    private void dfs(int l, int r, List<String> res, String s){
        if(r < l){
            return;
        }
        if(r==0){
            res.add(new String(s));
            return;
        }
        if(l > 0){
            s=s+"(";
            dfs(l-1, r, res, s);
            s = s.substring(0, s.length() - 1);
            s=s+")";
            dfs(l, r-1, res, s);
        }else if(l == 0){
            while(r>0){
                s=s+")";
                r--;
            }
            dfs(l, r, res,s);
        }
    }
}
