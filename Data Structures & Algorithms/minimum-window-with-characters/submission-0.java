class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int[] res = {-1,-1};
        int l=0;
        int count = 0;
        int target = tMap.size();
        int minLen = Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++){
            windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r),0)+1);
            if(tMap.containsKey(s.charAt(r)) && windowMap.get(s.charAt(r)).equals(tMap.get(s.charAt(r)))){
                
                count++;
            }
            while(count == target){
                if((r-l+1) < minLen){
                    minLen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
            char lcar = s.charAt(l);
            windowMap.put(lcar, windowMap.get(lcar)-1);
            if(tMap.containsKey(lcar) && windowMap.get(lcar) < tMap.get(lcar)){
                count--;
            }
            l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(res[0],res[1]+1);
    }
}
