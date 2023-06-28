class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < path.length() ; i++){
            char x = path.charAt(i);
            if(x == '/'){
                dealWithSB(sb,s);
                sb = new StringBuilder();
            }
            else sb.append(x);
        }
        dealWithSB(sb,s);
        sb = new StringBuilder();
        while(!s.isEmpty()) sb.insert(0 , "/" + s.pop());
        if(sb.length() == 0) sb.append('/');
        return sb.toString();
    }
    public void dealWithSB(StringBuilder sb , Stack<String> s ){
        if(sb.toString().equals("..")){
        if(!s.isEmpty()) s.pop();
        }else if(!sb.isEmpty() && !sb.toString().equals(".")){
            s.push(sb.toString());
        }
    }
}