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
           if(map.containsKey(s.charAt(r))){
              if(l > map.get(s.charAt(r))){
                  map.put(s.charAt(r),r);
                  max = Math.max(max,(r - map.get(s.charAt(l)))+1);
              }else{
                l = map.get(s.charAt(r))+1;
                System.out.println("l moved to "+l+" and the max is "+max);
                map.put(s.charAt(r),r);
              } 
           }else{
              map.put(s.charAt(r),r);
              max = Math.max(max,(r - map.get(s.charAt(l)))+1);
              System.out.println("r is "+r+" and the max is  "+max);
           }
           System.out.println(map);
           r++;
        }
        return max;
    }
}
