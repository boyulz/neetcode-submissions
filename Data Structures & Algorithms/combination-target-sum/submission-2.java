class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bt(0, nums, target, path, res);
        return res;
    }

    private void bt(int i, int[] nums, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (i == nums.length) {
            return;
        }
        if (nums[i] <= target) {
            path.add(nums[i]);
            bt(i, nums, target-nums[i], path, res);
            path.removeLast();
        }

        bt(i+1, nums, target, path, res);
    }
}
