class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < isConnected.length ; i++){
            ArrayList<Integer> x = new ArrayList<>();
            for(int j = 0; j < isConnected[i].length ; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1) x.add(j);
            }
            map.put(i,x);
        }
        boolean[] seen = new boolean[isConnected.length];
        int province = 0;
        for(int i = 0 ; i < isConnected.length ; i++){
            if(!seen[i]){
                province++;
                seen[i] = true;
                helper(i , map , seen);
            }
        }
        return province;
        
    }       
    public void helper(int num , HashMap<Integer , ArrayList<Integer>> map , boolean[] seen){
        ArrayList<Integer> arr = map.get(num);
        for(int j = 0 ; j < arr.size() ; j++){
            if(!seen[arr.get(j)]){
                seen[arr.get(j)] = true;
                helper(arr.get(j) , map , seen);
            }
        }
    }
}