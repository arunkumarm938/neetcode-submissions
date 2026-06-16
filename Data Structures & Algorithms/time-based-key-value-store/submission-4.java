class TimeMap {

    Map<String, TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tMap;
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
        TreeMap<Integer, String> tMap = map.get(key);
        Map.Entry<Integer, String> entry = tMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
