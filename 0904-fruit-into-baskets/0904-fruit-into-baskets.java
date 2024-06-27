class Solution {
    public int totalFruit(int[] fruits) {
        int j = 0;
        int start = 0;
        
        Map<Integer, Integer> basket = new HashMap<>();
        
        while (j < fruits.length) {
            basket.put(fruits[j], basket.getOrDefault(fruits[j], 0) + 1);
        
            if (basket.size() > 2) {
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if ( basket.get(fruits[start]) == 0 ) {
                    basket.remove(fruits[start]);
                }
                start++;
            }
            j++;
        }
        return j - start;
    }
}