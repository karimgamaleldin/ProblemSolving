class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String e : emails){
            String[] t = e.split("@");
            String x = fix(t[0]) + "@" + t[1];
            set.add(x);
        }
        return set.size();
    }
    public String fix(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() && s.charAt(i) != '+' ; i++){
            if(s.charAt(i) != '.') sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}