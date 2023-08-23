class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            int[] alph = new int[26];
            for(int j = 0 ; j < strs[i].length() ;j++){
                alph[strs[i].charAt(j) - 'a']++;
            }
            String x = Arrays.toString(alph);
            if(!map.containsKey(x)) map.put(x , new ArrayList<>());
            map.get(x).add(strs[i]);
        }
        List<List<String>> sol = new ArrayList<>();
        for(List<String> l : map.values()){
            sol.add(l);
        }
        return sol;
    }
}