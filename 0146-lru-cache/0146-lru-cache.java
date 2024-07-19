class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Initialize LinkedHashMap with access order
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity; // Remove the eldest if the size exceeds capacity
            }
        };
    }

    public int get(int key) {
        // Return the value if the key exists, otherwise return -1
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        // Put the key-value pair into the map
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */