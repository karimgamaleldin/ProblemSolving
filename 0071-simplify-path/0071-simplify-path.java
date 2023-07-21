class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        int i = 0;
        while(i < n){
            StringBuilder temp = new StringBuilder();
            if(path.charAt(i) == '/'){
                if(sb.charAt(sb.length() - 1) != '/') sb.append('/');
                i++;
                continue;
            }
            while(i < n && path.charAt(i) != '/'){
                temp.append(path.charAt(i++));
            }
            String x = temp.toString();
            if(x.equals(".")) continue;
            else if(x.equals("..")){
                int m = sb.length() - 1;
                if(sb.length() != 1) sb.deleteCharAt(m--);
                while(m >= 1 && sb.charAt(m) != '/') sb.deleteCharAt(m--);
            }else{
                sb.append(x);
            }
        }
        if(sb.length() != 1 && sb.charAt(sb.length() - 1) == '/') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}