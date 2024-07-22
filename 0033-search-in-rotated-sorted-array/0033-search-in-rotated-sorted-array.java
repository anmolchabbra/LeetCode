class Solution {
    public int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) return m;
            if (arr[l] <= arr[m]) {//left side sorted
                if (target>= arr[l] && target <= arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                //right is sorted
                if (target> arr[m] && target <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        
        return -1;
    }
}