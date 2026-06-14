class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        int max = 0;
        for(char c: set){
            int l=0;
            int count = 0;
            for(int r=0;r<s.length();r++){  
                if(c==s.charAt(r)){
                    count++;
                }
                while((r-l+1)-count > k){
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }
                max=Math.max(max,r-l+1);
            }
        }
        return max;
    }
}
