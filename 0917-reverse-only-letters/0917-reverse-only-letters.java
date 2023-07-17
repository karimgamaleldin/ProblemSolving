class Solution {
    public String reverseOnlyLetters(String s) {
        char c[] = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(checkIfEnglishLetter(c[left]) && checkIfEnglishLetter(c[right])){
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }else{
                if(!checkIfEnglishLetter(c[left])){
                    left++;
                }
                if(!checkIfEnglishLetter(c[right])){
                    right--;
                }
            }
        }
        return new String(c);
        
    }
    public boolean checkIfEnglishLetter(char c){
        boolean f1 = c - 'a' < 26 && c - 'a' >= 0;
        boolean f2 = c - 'A' < 26 && c - 'A' >= 0;
        return f1 || f2;
    }
}