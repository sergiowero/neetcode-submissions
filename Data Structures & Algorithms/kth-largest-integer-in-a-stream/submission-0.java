class KthLargest {

    private final PriorityQueue<Integer> heap = new PriorityQueue<>();
    private final int heapSize ;

    public KthLargest(int k, int[] nums) {
        heapSize = k;
        for(Integer num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        
        if (heap.size() < heapSize) {
            heap.add(val);
        } else {
            if (val > heap.peek()) {
                heap.add(val);
                heap.poll();
            }
        }

        return heap.peek();
    }
}
