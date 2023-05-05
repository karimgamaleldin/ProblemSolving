class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++){
            ArrayList x = new ArrayList<>();
            for(int j = 0 ; j < i+1 ; j++){
                if(i > 1 && j > 0 && j < i ){
                    x.add(arr.get(i-1).get(j-1) + arr.get(i-1).get(j) );
                }
                else {
                    x.add(1);
                }
            }
            arr.add(x);
        }
        return arr;
    }
}