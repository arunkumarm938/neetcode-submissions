class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        Map<Integer, List<Integer>> frequencyMap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            if(!frequencyMap.containsKey(e.getValue())){
                frequencyMap.put(e.getValue(), new ArrayList<Integer>());
            }
            frequencyMap.get(e.getValue()).add(e.getKey());
        }
        int[] op = new int[k];
            for(int i=0;i<k;){
                for(Map.Entry<Integer, List<Integer>> e:frequencyMap.entrySet()){
                    for(int j:e.getValue()){
                        if(i==k){
                            break;
                        }
                        op[i++]=j;
                    }
                if(i==k){
                    break;
                }
            }
        }
        return op;
    }
}
