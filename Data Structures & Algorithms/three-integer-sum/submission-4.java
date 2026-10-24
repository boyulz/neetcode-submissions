class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i ++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == -nums[i]) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[l]);
                    path.add(nums[r]);
                    res.add(path);
                    while (l < r && nums[l] == nums[l+1])    l ++;
                    while (l < r && nums[r] == nums[r-1])    r --;
                    l ++;
                    r --;
                } else if (sum < -nums[i]) {
                    l ++;
                } else {
                    r --;
                }
            }
        }
        return res;
    }
}
