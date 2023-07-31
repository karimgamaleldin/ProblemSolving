class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashSet<Integer> seen = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!seen.contains(i)){
                seen.add(n);
                count++;
                dfs(seen , i , isConnected);
            }
        }
        return count;
    }
    public void dfs(HashSet<Integer> seen , int v , int[][] isConnected){
        int[] arr = isConnected[v];
        for(int i = 0 ; i < arr.length ; i++){
            if(!seen.contains(i) && arr[i] == 1){
                seen.add(i);
                dfs(seen , i , isConnected);
            }
        }
    }
}