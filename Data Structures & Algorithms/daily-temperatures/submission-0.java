class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] res = new int[temperatures.length];
        Stack<Integer> values = new Stack<>();
        Stack<Integer> indices = new Stack<>();

        values.push(temperatures[0]);
        indices.push(0);
        for (int i = 1 ; i < temperatures.length; i++) {

            int temp = temperatures[i];

            while (!values.empty() && temp > values.peek()) {
                values.pop();
                int index = indices.pop();
                res[index] = i - index;
            }

            values.push(temp);
            indices.push(i);
        }

        while (!values.empty()) {
            values.pop();
            int index = indices.pop();
            res[index] = 0;
        }

        return res;
    }
}
