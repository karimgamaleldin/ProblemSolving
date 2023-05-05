class Solution {
    public String longestCommonPrefix(String[] strs) {
        String r = strs[0];
        for(int i = 1 ; i < strs.length ; i++ ){
            int min = Math.min(r.length() , strs[i].length());
            String temp = "";
            for(int j = 0 ; j < min ; j++){
                if(strs[i].charAt(j) != r.charAt(j)) break;
                temp += r.charAt(j);
            }
            r = temp;
            if(temp.length() == 0) break;
        }
        return r;
    }
}