class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length();
        int m = ransomNote.length();
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) map.put(magazine.charAt(i) , map.getOrDefault(magazine.charAt(i) , 0) + 1);
        for(int i = 0 ; i < m ; i++){
            if(!map.containsKey(ransomNote.charAt(i))) return false;
            map.put(ransomNote.charAt(i) , map.get(ransomNote.charAt(i)) - 1);
            if(map.get(ransomNote.charAt(i)) == 0) map.remove(ransomNote.charAt(i));
        }
        return true;
    }
}