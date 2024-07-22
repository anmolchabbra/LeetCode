class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> rowGaps = new HashMap<>();
        int sum = wall.get(0).stream().reduce(0, (a, b) -> a + b);
        for (List<Integer> l : wall) {
            int gap = 0;
            for (Integer i : l) {
                gap += i;
                if (gap <= 0  || gap >= sum) break;
                rowGaps.put(gap, rowGaps.getOrDefault(gap, 0) + 1);
            }
        }
        Optional<Map.Entry<Integer, Integer>> maxGaps = rowGaps.entrySet().stream().max(Map.Entry.comparingByValue());
        int cuts =  wall.size();
        if (maxGaps.isPresent()) {
            int keyWithMaxGaps =  maxGaps.get().getValue();
            //total rows - gaps
            cuts -= keyWithMaxGaps;
        } 
    
        return cuts;
    }
}