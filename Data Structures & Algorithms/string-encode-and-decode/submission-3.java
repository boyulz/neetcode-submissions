class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        List<Integer> sizes = new ArrayList<>();
        for (String s : strs) {
            sizes.add(s.length());
        }
        StringBuilder res = new StringBuilder();
        for(int size : sizes) {
            res.append(size).append('*');
        }
        res.append('#');
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> strs = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (true) {
            if (str.charAt(i) == '#') {
                break;
            }
            int j = i;
            while (true) {
                if (str.charAt(j) == '*') {
                    break;
                }
                j ++;
            }
            sizes.add(Integer.valueOf(str.substring(i, j)));
            i = j + 1;
        }
        i ++;
        for (int size : sizes) {
            strs.add(str.substring(i, i + size));
            i += size;
        }
        return strs;
    }
}
