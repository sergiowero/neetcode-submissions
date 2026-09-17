class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 1) return 1;

        Integer[] indices = IntStream.range(0, position.length).boxed().toArray(Integer[]::new);

        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        LinkedList<Float> fleets = new LinkedList<>();

        for (int i: indices) {

            int pos = position[i];
            int sp = speed[i];

            float toa = (float) (target - pos) / sp;
            fleets.push(toa);

            if (fleets.size() >= 2 && fleets.peek() <= fleets.get(1))
                fleets.pop();
        }
        return fleets.size();
    }
}
