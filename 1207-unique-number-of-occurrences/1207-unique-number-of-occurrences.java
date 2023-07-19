class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> count = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++) count.put(arr[i] , count.getOrDefault(arr[i] , 0) + 1);
        HashSet<Integer> seen = new HashSet<>();
        for(int x : count.values()){
            if(seen.contains(x)) return false;
            seen.add(x);
        }
        return true;
    }
}