class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        int n = paths.size();
        for(int i = 0 ; i < n ; i++){
            List<String> x = paths.get(i);
            set.add(x.get(0));
        }
        for(int i = 0 ; i < n ; i++){
            List<String> x = paths.get(i);
            if(!set.contains(x.get(1))) return x.get(1);
        }
        return " ";
        
    }
}