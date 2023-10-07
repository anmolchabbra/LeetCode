class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        int groups = hand.length / groupSize;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) <= 0) {
                continue;
            }
            for (int j = 1; j < groupSize; j++) {
                int count = map.getOrDefault(hand[i] + j, 0);
                if (count > 0)
                    map.put(hand[i] + j, count - 1);
                else 
                    return false;
            }
            map.put(hand[i], map.get(hand[i]) - 1);
        }
        return true;
    }
}