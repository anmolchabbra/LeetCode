class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            if (s.isEmpty() || asteroids[i] > 0) {
                s.push(asteroids[i]);
            } else {
                while (true) {
                    int peek = s.peek();
                    if (peek < 0) {
                        s.push(asteroids[i]);
                        break;
                    } else if (peek == -asteroids[i]) {
                        s.pop();
                        break;
                    } else if (peek > -asteroids[i]) {
                        break;
                    } else {
                        s.pop();
                        if (s.isEmpty()) {
                            s.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] output = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            output[i] = s.pop();
        }
        return output;
    }
}