class Solution {
    public String reversePrefix(String word, char ch) {
        char c[] = word.toCharArray();
        int i = 0;
        while(i < c.length){
            if(ch == c[i]) break;
            i++;
        }
        if(i == c.length) return word;
        int left = 0;
        while(left <= i){
            char temp = c[left];
            c[left] = c[i];
            c[i] = temp;
            left++; i--;
        }
        return new String(c);
    }
}