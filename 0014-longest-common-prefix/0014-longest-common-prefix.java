class Solution {
    public String longestCommonPrefix(String[] strs) {
        // for(int i = 1 ; i < strs.length ; i++ ){
        //     int min = Math.min(r.length() , strs[i].length());
        //     String temp = "";
        //     for(int j = 0 ; j < min ; j++){
        //         if(strs[i].charAt(j) != r.charAt(j)) break;
        //         temp += r.charAt(j);
        //     }
        //     r = temp;
        //     if(temp.length() == 0) break;
        // }
        // return r;
        StringBuilder r = new StringBuilder();
        for(int i = 0 ; i < strs[0].length() ; i++){
            for(int j = 0 ; j < strs.length ; j++){
                if(i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) return r.toString();
            }
            r.append(strs[0].charAt(i));
        }
        return r.toString();
    }
}