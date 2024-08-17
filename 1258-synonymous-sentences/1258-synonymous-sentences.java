class Solution {
    private Map<String, List<String>> map;
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        map = new HashMap<>();
        //made a grapgh
        for (List<String> list : synonyms) {
            isConnected(list.get(0), list.get(1));
            isConnected(list.get(1), list.get(0));
        }
        //do bfs
        Set<String> ans = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(text);
        while (!q.isEmpty()) {
            String front = q.remove();
            ans.add(front);
            String[] words = front.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) continue;
                for (String word : map.get(words[i])) {
                    words[i] = word;
                    String toAdd = String.join(" ", words);
                    boolean res = ans.add(toAdd);
                    if (res) q.add(toAdd);             
                }
            }
        }
        return new ArrayList<>(ans);
    }
    
    private void isConnected(String key, String value) {
        map.putIfAbsent(key,new ArrayList<String>());
        map.get(key).add(value);
    }
}