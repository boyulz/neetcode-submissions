class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bt(nums, 0, target, path, ans);
        return ans;
    }

    private void bt(int[] nums, int idx, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (idx == nums.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        bt(nums, idx + 1, target, path, ans);

        if (target >= nums[idx]) {
            path.add(nums[idx]);
            bt(nums, idx, target - nums[idx], path, ans);
            path.remove(path.size()-1);
        }
    }
}
