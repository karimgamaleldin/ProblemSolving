class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int n1 = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n1 ; i++) {
            map.put(s1.charAt(i) , map.getOrDefault(s1.charAt(i) , 0 ) +  1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        int n2 = s2.length();
        int left = 0; // sliding window
        for(int i = 0 ; i < n2 ; i++){
            char x = s2.charAt(i);
            if(!map.containsKey(x)){
                left = i + 1;
                map2 = new HashMap<>();
            }else{
                map2.put(x , map2.getOrDefault(x , 0) + 1);
                while(map.get(x) < map2.get(x)){
                    char y = s2.charAt(left);
                    map2.put(y , map2.get(y) - 1);
                    if(map2.get(y) == 0) map2.remove(y);
                    left++;
                }
                if(i - left + 1 == n1) return true;
            }
        }
        return  false;
        // if(s1.length() > s2.length()) return false;
        // int[] alph = new int[26];
        // int allZeros = 26;
        // for(int i = 0; i < s1.length() ; i++){
        //     alph[s1.charAt(i) - 'a']++;
        //     if(alph[s1.charAt(i) - 'a'] == 1) allZeros--; 
        // }
        // int left = 0;
        // int i = 0;
        // for(; i < s1.length() ;i++) {
        //     alph[s2.charAt(i) - 'a']--;
        //     if(alph[s2.charAt(i) - 'a'] == 0) allZeros++; 
        //     else if(alph[s2.charAt(i) - 'a'] == -1) allZeros--;
        // }
        // i--;
        // if(allZeros == 26) return true;
        // while(i < s2.length()){
        //     alph[s2.charAt(left) -'a']++;
        //     if(alph[s2.charAt(left) - 'a'] == 1) allZeros--; 
        //     else if(alph[s2.charAt(left) - 'a'] == 0) allZeros++; 
        //     left++;
        //     i++;
        //     if(i < s2.length()){
        //         alph[s2.charAt(i) - 'a']--;
        //         if(alph[s2.charAt(i) - 'a'] == 0) allZeros++; 
        //         else if (alph[s2.charAt(i) - 'a'] == -1) allZeros--;
        //     }
        //     if(allZeros == 26) return true;
        // }
        // return false;
    }
}