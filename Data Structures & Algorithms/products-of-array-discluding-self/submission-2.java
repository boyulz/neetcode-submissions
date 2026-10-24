class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix_product = new int[n];
        prefix_product[0] = 1;
        for (int i = 0; i < n-1; i ++) {
            prefix_product[i+1] = prefix_product[i] * nums[i];
            if (prefix_product[i+1] == 0) {
                break;
            }
        }
        int[] suffix_product = new int[n];
        suffix_product[n-1] = 1;
        for (int i = n-1; i >= 1; i --) {
            suffix_product[i-1] = suffix_product[i] * nums[i];
            if (suffix_product[i-1] == 0) {
                break;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            res[i] = prefix_product[i] * suffix_product[i];
        }
        return res;
    }
}  
