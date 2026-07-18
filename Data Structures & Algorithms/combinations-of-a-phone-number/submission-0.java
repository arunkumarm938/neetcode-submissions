class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<String, String[]> dic = new HashMap<>();
        dic.put("2", new String[]{"a","b","c"});
        dic.put("3", new String[]{"d","e","f"});
        dic.put("4", new String[]{"g","h","i"});
        dic.put("5", new String[]{"j","k","l"});
        dic.put("6", new String[]{"m","n","o"});
        dic.put("7", new String[]{"p","q","r","s"});
        dic.put("8", new String[]{"t","u","v"});
        dic.put("9", new String[]{"w","x","y","z"});
        dfs(res, dic,0, 0, digits, new StringBuilder());
        return res;
    }
    private void dfs(List<String> res, Map<String, String[]> dic, int i, int j, String digits, StringBuilder sb){
        if(i == digits.length()){
            if(sb.length()>0){
                res.add(sb.toString());
            }
            return;
        }
        String cur = digits.substring(i,i+1);
        for(int k=0;k<dic.get(cur).length;k++){
            sb.append(dic.get(cur)[k]);
            dfs(res, dic, i+1, k, digits, sb);
            sb.setLength(sb.length()-1);
        }
    }
}
