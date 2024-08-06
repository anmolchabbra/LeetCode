class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n== 0) return;
        int[] ans = new int[m + n];
        int i = 0, j = 0, index = 0;
        
        while ((i < m) && (j < n)) {
            System.out.print("here");
            if (nums1[i] < nums2[j]) {
                ans[index] = nums1[i];
                i++;
            } else {
                ans[index] = nums2[j];
                j++;
            }
            index++;
        }
           
        while (i < m) {
            ans[index] = nums1[i];
            i++;
            index++;
        }
        
        while (j < n) {
       //     System.out.println('here');
            ans[index] = nums2[j];
            j++;
            index++;
        }
        
        for (int k = 0; k < ans.length; k++) {
            // System.out.println(ans[k]);
            nums1[k] = ans[k];
        }
     
    }
}