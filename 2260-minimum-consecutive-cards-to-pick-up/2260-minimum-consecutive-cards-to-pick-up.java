import java.util.HashMap;

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < cards.length; j++) {
            int curr = cards[j];
            if (map.containsKey(curr)) {
                int prevIndex = map.get(curr);
                min = Math.min(min, j - prevIndex + 1);
            }
            // Update the map with the current index
            map.put(curr, j);
        }
        
        // If min is not updated, return -1
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
