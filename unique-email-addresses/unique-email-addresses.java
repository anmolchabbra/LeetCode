class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
         preProcess(emails, unique);
        return unique.size();
        
    }
    
    private void preProcess(String[] emails, Set<String> uniqueSet) {
        for (int i = 0; i < emails.length; i++) {
            String[] splits = emails[i].split("@");
            String localName = splits[0];
            String domainName = splits[1];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < localName.length(); j++) {
                char c = localName.charAt(j);
                if (c == '+') {
                    break;
                }
                if (c == '.') {
                    continue;
                }
                sb.append(c);
            }
            sb.append('@');
            sb.append(domainName);
            uniqueSet.add(sb.toString());
        }
        
    }
}