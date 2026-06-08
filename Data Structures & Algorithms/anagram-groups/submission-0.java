class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new TreeMap<String, List<String>>();
        for(String s: strs){
            char[] car = s.toCharArray();
            Arrays.sort(car);
            String tempStr = new String(car);
            if(!map.containsKey(tempStr)){
                map.put(tempStr, new ArrayList<String>());
            }
            map.get(tempStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
