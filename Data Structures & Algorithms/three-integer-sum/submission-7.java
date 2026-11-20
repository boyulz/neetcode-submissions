class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            // 1. 外层去重放在开头，逻辑更清晰
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            // 2. 剪枝：最小三数之和都大于 0，后面不可能有解，直接结束
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 3. 剪枝：当前数与最大两数之和都小于 0，当前数无解，跳过本轮
            if (x + nums[n - 2] + nums[n - 1] < 0) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            int target = -x;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    // 4. 使用 Arrays.asList 避免 ArrayList 默认扩容开销
                    ans.add(Arrays.asList(x, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}