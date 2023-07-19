class Solution {
    char[][] s = new char[][]{{'a','b','c'} , {'d','e','f'} , {'g','h','i'} ,{'j','k','l'} , {'m','n','o'} , {'p','q','r','s'} , {'t','u','v'} , {'w','x','y','z'}} ;
    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<>();
         if(digits.length() == 0) return r;
        StringBuilder sb = new StringBuilder();
        backtrack(r , sb , digits , 0);
        return r;
    }
    public void backtrack(List<String> r , StringBuilder sb , String  digits , int index){
        if(sb.length() == digits.length() || index == digits.length()){
            r.add(sb.toString());
            return;
        }
        int button = Integer.parseInt("" + digits.charAt(index));
        char[] mapping = s[button - 2];
        for(int i = 0 ; i < mapping.length ; i++){
            sb.append(mapping[i]);
            backtrack(r , sb , digits , index + 1);
            sb.delete(sb.length() - 1 , sb.length());
        }
    }
}