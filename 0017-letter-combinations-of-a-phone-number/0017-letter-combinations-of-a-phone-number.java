class Solution {
    static char[][] phonePad = new char[][]{{'a','b','c'}, {'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, digits, 0);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder sb, String digits, int i){
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        char[] arr = phonePad[c - '2'];
        for(char a : arr){
            sb.append(a);
            backtrack(res, sb, digits, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}