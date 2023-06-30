class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0 ; i < k ; i++){
            if(isVowel(s.charAt(i))) count++;
        }
        maxCount = count;
        for(int i = k ; i < s.length() ;i++){
            int a = isVowel(s.charAt(i)) ? 1 : 0;
            int b = isVowel(s.charAt(i-k)) ? 1 : 0;
            count += a - b;
            if(maxCount < count) maxCount = count;
        }
        return maxCount;
    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}