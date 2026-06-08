class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            map.merge(s.charAt(i),1, Integer::sum);
        }
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }{
                map.merge(t.charAt(i), -1, Integer::sum);
            }
        }
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            if(e.getValue()!=0){
                return false;
            }
        }
        return true;
    }
}
