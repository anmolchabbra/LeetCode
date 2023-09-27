class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char stackTop = stack.peek();
                System.out.println("Stack TOP " + "" + stackTop + 
"char" + c);
                if ((c == ')' && stackTop == '(') || ((c == ']' && stackTop == '['))
                   || (c == '}' && stackTop == '{')) {
                    stack.pop(); 
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}