class Solution {

    private PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        for (Integer stone: stones) {
            heap.add(stone);
        } 

        while (heap.size() > 1) {
            int val1 = heap.poll();
            int val2 = heap.poll();

            heap.add(Math.abs(val1 - val2));
        }

        return heap.poll();
    }
}
