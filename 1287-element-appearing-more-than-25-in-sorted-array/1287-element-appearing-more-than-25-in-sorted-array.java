class Solution {
    public int findSpecialInteger(int[] arr) {
        int  occurrence = 0;
            occurrence = arr.length / 4;
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = arr[0];
        if (arr.length == 1) {
            return ans;
        }
        System.out.println( occurrence);
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int curr = map.get(arr[i]);
                if (curr + 1 >  occurrence) {
                    ans = arr[i];
                    break;
                }
                map.put(arr[i], curr + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return ans;
    }
}