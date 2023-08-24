class Solution {
    char[][] s = new char[][]{{'a','b','c'} , {'d','e','f'} , {'g','h','i'} ,{'j','k','l'} , {'m','n','o'} , {'p','q','r','s'} , {'t','u','v'} , {'w','x','y','z'}} ;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        StringBuilder sb = new StringBuilder();
        backtrack(ans , sb , 0 , digits);
        return ans;
    }
    public void backtrack(List<String> ans , StringBuilder sb , int i , String digits){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        char[] chars = s[digits.charAt(i) - '2'];
        for(char c : chars){
            sb.append(c);
            backtrack(ans , sb , i + 1 , digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}