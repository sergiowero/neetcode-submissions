class Solution {
    public int findMin(int[] nums) {
        
        // [3,4,5,6,1,2]       // [4,5,0,1,2,3]
                               // [4,5,0,_,_,_]

        // [5,1,2,3,4]


        if(nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
