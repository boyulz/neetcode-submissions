class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i ++) {
            int target = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> tri = new ArrayList<>();
                    tri.add(nums[i]);
                    tri.add(nums[l]);
                    tri.add(nums[r]);
                    ans.add(tri);
                    while (l < r && nums[l] == nums[l+1]) {
                        l ++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r --;
                    }
                    l ++;
                    r --;
                } else if (sum > target) {
                    r --;
                } else {
                    l ++;
                }
            }
            while (i+1 < nums.length - 2 && nums[i] == nums[i+1]) {
                i ++;
            }
        }
        return ans;
    }
}
