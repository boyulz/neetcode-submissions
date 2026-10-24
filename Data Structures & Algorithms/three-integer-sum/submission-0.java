class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n-2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            int target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[l]);
                    path.add(nums[r]);
                    ans.add(path);
                    while (l < r && nums[r-1] == nums[r]) {
                        r --;
                    }
                    while (l < r && nums[l+1] == nums[l]) {
                        l ++;
                    }
                    r --;
                    l ++;
                } else if (nums[l] + nums[r] > target) {
                    r --;
                } else {
                    l ++;
                }
            }
            i ++;
        }
        return ans;
    }
}
