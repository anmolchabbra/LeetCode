public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);  // Append the length of the string
            sb.append('#');  // Append the separator
            sb.append(s);    // Append the actual string
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String lenPart = "";
            // Gather the length of the next string
            while (str.charAt(i) != '#') {
                lenPart += str.charAt(i);
                i++;
            }
            // Skip the '#'
            i++;

            // Parse the length of the string
            int len = Integer.parseInt(lenPart);

            // Manually concatenate characters to form the string
            String toAdd = "";
            for (int j = 0; j < len; j++) {
                toAdd += str.charAt(i + j);
            }
            // Add the string to the decoded list
            decodedList.add(toAdd);

            // Move the index past the extracted string
            i += len;
        }
        return decodedList;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));