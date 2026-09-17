class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        Set<String> operators = Set.of("*", "+", "-", "/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer curr = values.pop();
                Integer last = values.pop();

                Integer res = switch (token) {
                    case "*" -> curr * last;
                    case "+" -> curr + last;
                    case "-" -> last - curr;
                    case "/" -> last / curr;
                    default -> 0;
                };
                values.push(res);
            } else {
                values.push(Integer.parseInt(token));
            }
        }
        return values.pop();
    }
}
