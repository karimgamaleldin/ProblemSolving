class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> em = new HashSet<>();
        for(String e : emails){
            String st = processEmail(e);
            em.add(st);
        }
        return em.size();
    }
    public String processEmail(String email){
        StringBuilder sb = new StringBuilder();
        boolean ignore = false;
        for(int i = 0 ; i < email.length() ; i++){
            char c = email.charAt(i);
            if(c == '@'){
                sb.append(email.substring(i, email.length()));
                break;
            }else{
                if(c == '+'){
                    ignore = true;
                }
                else if(!ignore){
                    if(c != '.') sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}