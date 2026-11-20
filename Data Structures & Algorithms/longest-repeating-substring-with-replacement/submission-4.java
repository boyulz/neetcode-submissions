class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'A']++;

            // 只要当前窗口里“需要替换的字符数” > k，就缩小左边界
            while ((r - l + 1) - getMaxFreq(cnt) > k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    // 遍历 26 个字母，获取当前窗口内真实的最高频次
    private int getMaxFreq(int[] cnt) {
        int max = 0;
        for (int c : cnt) {
            max = Math.max(max, c);
        }
        return max;
    }
}