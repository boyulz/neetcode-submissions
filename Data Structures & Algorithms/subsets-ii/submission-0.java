class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
        
        path.add(nums[i]);
        bt(i+1, nums, path, res);
        path.removeLast();

        i++;
        while (i < nums.length && nums[i] == nums[i-1]) {
            i++;
        }
        bt(i, nums, path, res);
    }
}
