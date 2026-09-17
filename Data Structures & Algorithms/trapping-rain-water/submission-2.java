class Solution {
    public int trap(int[] height) {
        
        // store prefix max values
        int[] prefixes = new int[height.length];
        prefixes[0] = height[0];
        for (int i = 1 ; i < height.length ; i++) {
            prefixes[i] = Math.max(prefixes[i - 1], height[i]);
        }

        // store suffix max values
        int[] suffixes = new int[height.length];
        suffixes[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2 ; i >=0 ; i--) {
            suffixes[i] = Math.max(suffixes[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 1 ; i < height.length - 1 ; i++) {
            int minHeight = Math.min(prefixes[i - 1], suffixes[i + 1]);
            int val = minHeight - height[i];
            if (val > 0) water += val;
        }
        return water;
    }
}
