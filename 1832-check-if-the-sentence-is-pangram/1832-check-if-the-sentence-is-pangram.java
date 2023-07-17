class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        int all = 1 << 26;
        int found = 0;
        for(int i = 0 ; i < n ;i++){
            int t = sentence.charAt(i) - 'a';
            t = 1 << t;
            found |=  t;
        }
        return found + 1 == all;
    }
    //     int n = sentence.length();
    //     HashSet<Character> set = new HashSet<>();
    //     for(int i = 0 ; i < n ; i++) {
    //         set.add(sentence.charAt(i));
    //         if(set.size() == 26) return true;
    //     }
    //     return set.size() == 26;
    // }
}