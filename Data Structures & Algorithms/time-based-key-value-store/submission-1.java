class TimeMap {
    Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair<>(timestamp, value));
        } else {
            List<Pair<Integer, String>> pair = new ArrayList<>();
            pair.add(new Pair<>(timestamp, value));
            map.put(key, pair);
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            int pos = binarySearch(map.get(key), timestamp);
            if (pos == -1) {
                return "";
            }
            return map.get(key).get(pos).getValue();
        } else {
            return "";
        }
    }

    private int binarySearch(List<Pair<Integer, String>> list, int timestamp) {
        int l = 0;
        int r = list.size()-1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            int midVal = list.get(mid).getKey();
            if (midVal == timestamp) {
                return mid;
            } else if (midVal > timestamp) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return r;
    }
}
