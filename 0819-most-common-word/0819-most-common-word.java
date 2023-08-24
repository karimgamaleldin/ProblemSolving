class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        for (String s : banned) ban.add(s);
        HashMap<String , Integer> count = new HashMap<>();
        int n = paragraph.length();
        int i = 0;
        while(i < n){
            char c = paragraph.charAt(i);
            if(check(c)) i++;
            else{
                StringBuilder sb = new StringBuilder();
                while(i < n && !check(paragraph.charAt(i))){
                    sb.append(lower(paragraph.charAt(i)));
                    i++;
                }
                String s = sb.toString();
                if(!ban.contains(s)) count.put(s , count.getOrDefault(s , 0) + 1);
            }
        }
        String ans = "";
        int max = 0;
        for(String k : count.keySet()){
            if(count.get(k) > max){
                ans = k;
                max = count.get(k);
            }
        }
        return ans;
    }
    public boolean check(char c){
        return c == '\'' || c == '!' || c == '?' || c == ',' || c == ';' || c == '.' || c == '"' || c == ' ';
    }
    public char lower(char c){
        if(c >= 'a' && c <= 'z') return c;
        return (char) (c + 32);
    }
}