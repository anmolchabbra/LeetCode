class Solution {
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            System.out.println("Start" + start + "end" + end);
            int mid = start + (end - start)/ 2;
            System.out.println("Mid " +mid);
            if (arr[mid] == target) return mid;
            //sorted
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                   start = mid + 1; 
                }
            }else if (arr[mid] <= arr[end]) {
                if (target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                   end = mid - 1;
                }
            }
        }
        return -1;
    }
}