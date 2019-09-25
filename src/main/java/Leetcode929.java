class Solution {
    
    /** Using stringbuilder and substring - 10ms 38.1MB **/
    public int numUniqueEmails(String[] emails) {
        int counter = 0;
        Set<String> emailSet = new HashSet<>();
        
        for (String s : emails) {
            int index = -1;
            StringBuilder sb = new StringBuilder();
            
            while (s.charAt(++index) != '@') {
                if (s.charAt(index) == '.') continue;
                else if (s.charAt(index) == '+') break;
                else sb.append(s.charAt(index));
            }

            if (emailSet.add(sb.append('@').toString() + s.substring(s.indexOf('@') + 1))) counter++;
        }
        
        return counter;
    }
}
