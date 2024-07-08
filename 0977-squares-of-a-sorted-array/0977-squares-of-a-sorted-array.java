class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] squares = new int[nums.length];
        int sqIndex = nums.length - 1;
        
        while (start <= end) {
            int sqStart = nums[start] * nums[start];
            int sqEnd = nums[end] * nums[end];
                
            if (sqStart > sqEnd) {
                squares[sqIndex]  = sqStart;
                start++;
            } else {
                squares[sqIndex] = sqEnd;
                end--;
            }
            sqIndex--;
        }
        
        return squares;
    }
}