class Solution {
    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        char[] chars = s.toCharArray();

        int l = 0, r = 1;
        int max = 0;
        Map<Character, Integer> freqs = new HashMap<>();

        freqs.merge(chars[l], 1, Integer::sum);

        while(r < chars.length) {

            if (freqs.getOrDefault(chars[r], 0) == 1) {
                freqs.merge(chars[l], -1, Integer::sum);
                l++;
            } else {
                freqs.merge(chars[r], 1, Integer::sum);
                r++;
                max = Math.max(max, r - l);
            }
        }

        return max;

    }
}
