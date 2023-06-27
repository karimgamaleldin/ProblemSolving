class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder r = new StringBuilder();
        int i = 0 ;
        int j = 0 ;
        while(i < word1.length() && j < word2.length()){
            r.append(word1.charAt(i++));
            r.append(word2.charAt(j++));
        }
        if(i != word1.length())
            for(; i < word1.length() ; i++) r.append(word1.charAt(i));
        if(j != word2.length())
            for(; j < word2.length() ; j++) r.append(word2.charAt(j));
        return r.toString();
        
    }
}