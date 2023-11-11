class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList();
        StringBuilder sb = new StringBuilder();
        backtrack(list, sb, n, n);
        return list;
    }
    
    private void backtrack(List<String> list, StringBuilder sb, int i, int j){
        if(i == 0 && j == 0){
            list.add(sb.toString());
        }
        if(i > 0){
            sb.append('(');
            backtrack(list, sb, i - 1, j);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(j > i){
            sb.append(')');
            backtrack(list, sb, i, j - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}