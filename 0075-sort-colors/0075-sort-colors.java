class Solution {
    public void sortColors(int[] nums) {
       
        
        int l = 0;
        
        int zeroEnd = 0;
        
        int twoStart = nums.length - 1;
        
        while (l <= twoStart) {
            if (nums[l] == 0) {
                int temp = nums[l];
                nums[l] = nums[zeroEnd];
                nums[zeroEnd] = temp;
                l++;
                zeroEnd++;
            } else if (nums[l] == 2) {
                int temp = nums[l];
                nums[l] = nums[twoStart];
                nums[twoStart] = temp;
                twoStart--;
            } else 
                l++;
        }

    }
}