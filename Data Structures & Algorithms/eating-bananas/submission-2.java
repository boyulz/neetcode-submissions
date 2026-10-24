class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        return binarySearch(piles, h, 1, r);
    }

    private boolean canEatAll(int[] piles, int rate, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + rate - 1) / rate;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(int[] piles, int h, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canEatAll(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
