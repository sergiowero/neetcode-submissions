class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0 ; i < nums.length ; i++) {

            int j = i, k = nums.length - 1;
            while (j < k) {
                if (j == i) {
                    j++;
                    continue;
                }

                if (k == i) {
                    k--;
                    continue;
                }

                int target = -nums[i];
                if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                 res.add(List.of(nums[i],nums[j], nums[k]));
                 k--;
                 j++;
                }
            }
        }

        return res.stream().toList();
    }
}
