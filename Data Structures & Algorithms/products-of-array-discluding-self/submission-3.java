class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        prefix[0] = 1;
        suffix[len-1] = 1;

        int prod = 1;
        for (int i = 0; i < len - 1; i ++) {
            prod = prefix[i] * nums[i];
            prefix[i + 1] = prod;
        }

        prod = 1;
        for (int i = len-1; i > 0; i --) {
            prod = suffix[i] * nums[i];
            suffix[i - 1] = prod;
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i ++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }


}  
