class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        
        dfs(candidates, 0, target, path, res);

        return res;
    }

    private void dfs(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        
        if (idx == candidates.length || target < 0) {
            return;
        }

        path.add(candidates[idx]);
        dfs(candidates, idx + 1, target - candidates[idx], path, res);
        path.removeLast();

        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx ++;
        }
        dfs(candidates, idx + 1, target, path, res);
    }
}
