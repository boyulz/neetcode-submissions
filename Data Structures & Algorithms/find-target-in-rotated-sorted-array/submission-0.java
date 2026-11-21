class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minPos = findMinPos(nums);
        if (target == nums[minPos]) {
            return minPos;
        }
        int pre = binarySearch(nums, 0, minPos-1, target);
        if (pre != -1) {
            return pre;
        }
        int suf = binarySearch(nums, minPos, n-1, target);
        if (suf != -1) {
            return suf;
        }
        return -1;
    }


    private int findMinPos(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if (nums[mid] > nums[n-1]) {
                l++;
            } else {
                r--;
            }
        }
        return r+1;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        int n = nums.length;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r--;
            } else {
                l++;
            }
        }
        return -1;
    }
}
