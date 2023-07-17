class Solution {
    public char repeatedCharacter(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            char x = s.charAt(i);
            if(set.contains(x)) return x;
            set.add(x);
        }
        return ' ';
    }
}