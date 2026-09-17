class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }


        int max = 0;
        for (int num : set) {
            int size = 1;
            int n = num - 1;
            while (set.contains(n)) {
                size++;
                n = n -1;
            }
            max = Math.max(max, size);
        }

        return max;

    }
}
