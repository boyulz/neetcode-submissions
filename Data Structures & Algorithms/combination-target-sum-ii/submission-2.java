class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bt(0, candidates, target, path, res);
        return res;
    }

    private void bt(int i, int[] candidates, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (i == candidates.length) {
            return;
        }
        if (candidates[i] <= target) {
            path.add(candidates[i]);
            bt(i+1, candidates, target-candidates[i], path, res);
            path.removeLast();
        

            i++;
            while (i < candidates.length && candidates[i] == candidates[i-1]) {
                i ++;
            }
            bt(i, candidates, target, path, res);
        }
    }
}
