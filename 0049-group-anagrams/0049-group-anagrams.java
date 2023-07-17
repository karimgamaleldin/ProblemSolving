class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            String s = strs[i];
            int n = s.length();
            int[] alph = new int[26];
            for(int j = 0 ; j < n ; j++){
                alph[s.charAt(j) - 'a']++;
            }
            String key = Arrays.toString(alph);
            if(!map.containsKey(key)) map.put(key , new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> r = new ArrayList<>();
        for(List<String> value : map.values()){
            r.add(value);
        }
        return r;
    }
}