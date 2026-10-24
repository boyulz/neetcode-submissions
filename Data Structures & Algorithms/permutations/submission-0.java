class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] onPath = new boolean[nums.length];
        dfs(nums, 0, onPath, path, res);
        return res;
    }

    private void dfs(int[] nums, int idx, boolean[] onPath, List<Integer> path, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (onPath[i] == false) {
                path.add(nums[i]);
                onPath[i] = true;
                dfs(nums, idx + 1, onPath, path, res);
                path.removeLast();
                onPath[i] = false;
            }
        }
    }
}
