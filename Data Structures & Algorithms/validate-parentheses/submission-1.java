class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if(stack.empty()) return false;
                char other = stack.pop();
                if (c != other)
                    return false;
            }
        }

        return stack.empty();
    }
}
