class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            freqs.merge(nums[i], 1, Integer::sum);
        }

        var buckets = freqs.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        () -> new TreeMap<Integer, List<Integer>>(Comparator.reverseOrder()),
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));


        int[] res = new int[k];
        int i = 0;
        for (var entry : buckets.entrySet()) {
            
            for (var val : entry.getValue()) {
                res[i++] = val;
                if (i == k) {
                    return res;
                }
            }

        }
        
        return res;
    }
}
