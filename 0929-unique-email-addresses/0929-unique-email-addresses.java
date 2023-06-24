class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        for(int i = 0 ; i < emails.length;i++){
            StringBuilder sb = new StringBuilder();
            boolean atFound = false;
            boolean plusFound = false;
            for(int j = 0 ; j < emails[i].length() ; j++){
                char currChar = emails[i].charAt(j);
                if(atFound) sb.append(currChar);
                else{
                    if(currChar == '@') {
                        sb.append('@');
                        atFound = true;
                    }
                    if(currChar== '+') plusFound = true;
                    if(currChar == '.') continue;
                    if(!plusFound && !atFound)sb.append(currChar);

                }
            }
            if(set.contains(sb.toString())) continue;
            System.out.println(sb.toString());
            set.add(sb.toString());
            count++;
        }
        return count;
    }
}