class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, path, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, path, res);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
