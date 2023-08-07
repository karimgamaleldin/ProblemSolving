class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        char sol = 0;
        int r = letters.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(letters[mid] <= target) {
                l = mid + 1;
                sol = letters[mid];
            }
            else r = mid - 1;
        }
        return l == letters.length ? letters[0] : letters[l];
    }
}