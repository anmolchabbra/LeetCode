import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            // While we can remove digits and stack is not empty and the top of the stack is greater than the current digit
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Remove any remaining digits if k > 0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Build the final number from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Reverse to get the correct order
        result.reverse();
        
        // Remove leading zeros
        String resultStr = result.toString().replaceAll("^0+", "");
        
        // If the result is empty, it means the number is zero
        return resultStr.isEmpty() ? "0" : resultStr;
    }
}
