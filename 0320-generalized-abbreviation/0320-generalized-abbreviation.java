public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, 0, 0, "", res);
        return res;
    }
    
    // curLen: length of current abbreviation
    // pos: current position in the word
    // path: current path
    // res: result list
    private void dfs(String word, int curLen, int pos, String path, List<String> res) {
        if (pos == word.length()) {
            if (curLen != 0) {
                path += curLen;
            }
            res.add(path);
            return;
        }
        
        // abbreviate current character
        dfs(word, curLen + 1, pos + 1, path, res);
        
        // keep current character
        // restart abbreviating, append the count and the current character to the string
        if (curLen != 0) {
          path += curLen;
        }
        String newWord = path + word.charAt(pos);
        dfs(word, 0, pos + 1, newWord, res);
    }
}