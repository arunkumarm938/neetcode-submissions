class Solution {
    public String longestCommonPrefix(String[] strs) {
        int shortestStringLength = Integer.MAX_VALUE;
        int shortestStrIndex = 0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length() < shortestStringLength){
                shortestStringLength = strs[i].length();
                shortestStrIndex = i;
            }
        }
        for(int i=0;i<shortestStringLength;i++){
            char c = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i) != c){
                    return str.substring(0,i);
                }
            }
        }
        return strs[shortestStrIndex].substring(0,shortestStringLength);
    }
}