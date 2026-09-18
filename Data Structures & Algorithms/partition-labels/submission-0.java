class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> sol = new ArrayList<>();
        Map<Character, int[]> map= new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), new int[2]);
                map.get(s.charAt(i))[0] = i;
            }
            map.get(s.charAt(i))[1] = i;
        }
        List<int[]> list = new ArrayList<>(map.values());
        Set<Character> set = new HashSet<>();
        int total = 0;
        for (int i=0;i<list.size()&& total < s.length();i++) {
            int start = list.get(i)[0];
            if(set.contains(s.charAt(start))){
                continue;
            }
            set.add(s.charAt(start));
            int end = list.get(i)[1];
            for(int j=1;j<list.size();j++){
                if(list.get(j)[0] > start && list.get(j)[0] < end){
                    set.add(s.charAt(list.get(j)[0]));
                    if(list.get(j)[1] > end){
                        end = list.get(j)[1];
                    }
                }
            }
            sol.add(end-start + 1);
            total+=end-start;
        }
        return sol;
    }
}
