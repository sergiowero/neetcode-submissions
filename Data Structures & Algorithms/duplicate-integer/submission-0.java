class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        int i = 0 ;
        while(i < nums.length) {
            if (!set.add(nums[i])) return true;
            i++;
        }

        return false;
    }
}