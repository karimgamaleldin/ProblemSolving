class Solution {
    // pacific ocean touch left and top
    // atlantic ocean touch right and bottom
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] seenP = new boolean[m][n];
        boolean[][] seenA = new boolean[m][n];
        List<List<Integer>> res = new LinkedList<>();
        HashSet<List<Integer>> pSet = new HashSet<>();
        HashSet<List<Integer>> aSet = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            dfs(i , 0 , heights , seenP , pSet , Integer.MIN_VALUE);
            dfs(i , n - 1 , heights , seenA , aSet , Integer.MIN_VALUE);
        }
        for(int i = 0 ; i < n ; i++){
            dfs(0 , i , heights , seenP , pSet , Integer.MIN_VALUE);
            dfs(m - 1 , i , heights , seenA , aSet , Integer.MIN_VALUE);
        }
        for(List<Integer> a : aSet)
            if(pSet.contains(a)) res.add(a);
        return res;
    }
    public void dfs(int i , int j , int[][] heights , boolean[][] seen , HashSet<List<Integer>> set , int curr){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || seen[i][j]) return;
        if(heights[i][j] < curr) return;
        seen[i][j] = true;
        List<Integer> l = new LinkedList<>();
        l.add(i);
        l.add(j);
        set.add(l);
        dfs(i+1 , j , heights , seen , set , heights[i][j]);
        dfs(i-1 , j , heights , seen , set , heights[i][j]);
        dfs(i , j+1 , heights , seen , set , heights[i][j]);
        dfs(i , j-1 , heights , seen , set , heights[i][j]);
    }
}