class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] alph = new int[26];
        int allZeros = 26;
        for(int i = 0; i < s1.length() ; i++){
            alph[s1.charAt(i) - 'a']++;
            if(alph[s1.charAt(i) - 'a'] == 1) allZeros--; 
        }
        int left = 0;
        int i = 0;
        for(; i < s1.length() ;i++) {
            alph[s2.charAt(i) - 'a']--;
            if(alph[s2.charAt(i) - 'a'] == 0) allZeros++; 
            else if(alph[s2.charAt(i) - 'a'] == -1) allZeros--;
        }
        i--;
        if(allZeros == 26) return true;
        while(i < s2.length()){
            alph[s2.charAt(left) -'a']++;
            if(alph[s2.charAt(left) - 'a'] == 1) allZeros--; 
            else if(alph[s2.charAt(left) - 'a'] == 0) allZeros++; 
            left++;
            i++;
            if(i < s2.length()){
                alph[s2.charAt(i) - 'a']--;
                if(alph[s2.charAt(i) - 'a'] == 0) allZeros++; 
                else if (alph[s2.charAt(i) - 'a'] == -1) allZeros--;
            }
            if(allZeros == 26) return true;
        }
        return false;
    }
}