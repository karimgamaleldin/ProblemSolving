class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int n = jewels.length();
        for(int i = 0 ; i < n ; i++) set.add(jewels.charAt(i));
        int count = 0;
        n = stones.length();
        for(int i = 0 ; i < n ; i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
        
    }
}