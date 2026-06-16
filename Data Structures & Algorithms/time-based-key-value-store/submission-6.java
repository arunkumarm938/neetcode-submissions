class TimeMap {

    Map<String, Map<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Map<Integer, String> tMap;
        if(map.containsKey(key)){
            tMap = map.get(key);
        }else {
            tMap = new TreeMap<Integer, String>();
            map.put(key, tMap);
        }
        tMap.put(timestamp, value);
        System.out.println(tMap);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        Map<Integer, String> tMap = map.get(key);
        if(tMap.containsKey(timestamp)){
            return tMap.get(timestamp);
        }
        Integer[] arr = tMap.keySet().toArray(new Integer[0]);
        int l = 0;
        int r = arr.length - 1;
        int min = -1;
        while(l <= r){
            int m = l + (r - l)/2;
            if(arr[m] > timestamp){
                r = m - 1;
            }else{
                min = arr[m];
                l = m + 1;
            }
        }
        return min == -1 ? "": tMap.get(min);
    }
}
