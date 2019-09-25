class Solution {
    
    public int numUniqueEmails(String[] emails) {
        int counter = 0;
        Set<String> emailSet = new HashSet<>();
        
        for (String s : emails) {
            int index = -1, len = s.length();
            StringBuilder sb = new StringBuilder();
            
            while (s.charAt(++index) != '@') {
                if (s.charAt(index) == '.') continue;
                else if (s.charAt(index) == '+') {
                    index = s.indexOf('@');
                    break;
                } else sb.append(s.charAt(index));
            }
            
            sb.append('@');
            while (index++ < len - 1) sb.append(s.charAt(index));
            System.out.println(sb.toString());
            if (emailSet.add(sb.toString())) counter++;
        }
        
        return counter;
    }
}
