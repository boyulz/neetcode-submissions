class Solution {
    // 选或不选
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bt(0, nums, path, res);
        return res;
    }

    private void bt(int i, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList(path));
            return;
        }

        // choose
        path.add(nums[i]);
        bt(i+1, nums, path, res);
        path.removeLast();

        // not choose
        bt(i+1, nums, path, res);
    }
}
