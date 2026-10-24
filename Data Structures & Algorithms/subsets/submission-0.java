class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList(path));
            return;
        }

        // Choose
        path.add(nums[idx]);
        dfs(nums, idx + 1, path, res);
        path.removeLast();

        // Not choose
        dfs(nums, idx + 1, path, res);
    }
}
