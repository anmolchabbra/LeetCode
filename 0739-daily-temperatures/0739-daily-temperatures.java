class Solution {
    class Pair {
        public int index;
        public int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > s.peek().value) {
                Pair p = s.pop();
                res[p.index] = i - p.index;
            }
            s.push(new Pair(i, temperatures[i]));
        }
        return res;
    }
}