class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, target, path, res);
        return res;
    }

    private void dfs(int[] nums, int idx, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0 || idx == nums.length) {
            return;
        }

        path.add(nums[idx]);
        dfs(nums, idx, target - nums[idx], path, res);
        path.removeLast();

        dfs(nums, idx + 1, target, path, res);
    }
}
