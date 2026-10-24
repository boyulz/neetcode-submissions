class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int n = nums[i];
            if (map.containsKey(target - n)) {
                return new int[]{map.get(target - n), i};
            } else {
                map.put(n, i);
            }
        }
        return new int[]{};
    }
}
