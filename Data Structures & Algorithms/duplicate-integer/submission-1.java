class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            int size = set.size();
            set.add(n);
            if (size == set.size()) {
                return true;
            }
        }
        return false;
    }
}