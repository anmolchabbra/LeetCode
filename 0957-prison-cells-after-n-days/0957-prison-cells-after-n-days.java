class Solution {
   public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean hasCycle = false;
        int cycleLength = 0;

        for (int day = 0; day < n; day++) {
            int[] nextDay = new int[8];

            // Calculate the next day's state
            for (int i = 1; i < 7; i++) {
                nextDay[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
            }

            String stateKey = arrayToString(nextDay);

            // Check if we have seen this state before
            if (seen.containsKey(stateKey)) {
                hasCycle = true;
                cycleLength = day - seen.get(stateKey);
                break;
            } else {
                seen.put(stateKey, day);
            }

            cells = nextDay;  // Update cells to the next day's state
        }

        // If a cycle is found, reduce n by the cycle length
        if (hasCycle) {
            n %= cycleLength;
            for (int day = 0; day < n; day++) {
                int[] nextDay = new int[8];
                for (int i = 1; i < 7; i++) {
                    nextDay[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
                }
                cells = nextDay;
            }
        }

        return cells;
    }

    // Utility method to convert array to string (for use as a map key)
    private String arrayToString(int[] cells) {
        StringBuilder sb = new StringBuilder();
        for (int cell : cells) {
            sb.append(cell);
        }
        return sb.toString();
    }
}