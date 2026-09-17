class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefixes = new int[nums.length];
        prefixes[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            prefixes[i] = prefixes[i -1] * nums[i];
        }

        int[] suffixes = new int[nums.length];
        suffixes[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            suffixes[i] = suffixes[i + 1] * nums[i];
        }

        for (int i = 0 ; i < nums.length ; i++) {
            int prefix = i == 0 ? 1 : prefixes[i - 1];
            int suffix = i == nums.length - 1 ? 1 : suffixes[i + 1];
            nums[i] = prefix * suffix;
        }

        return nums;
    }
}  
