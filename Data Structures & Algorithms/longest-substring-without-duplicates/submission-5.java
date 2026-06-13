class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int l= 0;
        int r = 1;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l),0);
        while(r<s.length()){
           if(map.containsKey(s.charAt(r)) && l < map.get(s.charAt(r))+1){
              l = map.get(s.charAt(r))+1;
              map.put(s.charAt(r),r);
           }else{
              map.put(s.charAt(r),r);
              max = Math.max(max,(r - map.get(s.charAt(l)))+1);
           }
           r++;
        }
        return max;
    }
}
