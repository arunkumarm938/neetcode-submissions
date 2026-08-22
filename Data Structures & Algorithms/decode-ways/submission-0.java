class Solution {
    public int numDecodings(String s) {
        return dp(0, s, s.length(), new HashMap<>());
    }
    private int dp(int i, String s, int n, HashMap<Integer, Integer> map){
        if(i == n){
            return 1;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        int one = dp(i+1, s, n, map);
        if(i < n-1 && (Integer.parseInt(String.valueOf(s.substring(i,i+2))) < 27 )){
            int two = dp(i+2, s, n, map);
            map.put(i, one+two);
        }else{
            map.put(i, one);
        }
        return map.get(i);
    }
}
