class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        List[] bucket = new List[arr.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
        }
        
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<Integer>();
                bucket[count].add(key);
            } else {
                return false;
            }
        }
        
        return true;
    }
}