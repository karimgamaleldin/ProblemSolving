class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String , ArrayList<String>> map = new HashMap<String , ArrayList<String>>();
        for(int i = 0 ; i < strs.length ; i++){
            int[] characters = new int[26]; //sorted array of characters to know the amount of each characters (initialized by 0)
            for(int j = 0 ; j < strs[i].length() ; j++){
                char c = strs[i].charAt(j);
                ++characters[c - 'a']; // to increment the number of c in the array
            }
            String x = new String(Arrays.toString(characters)); //String of the shape of an array like: [1,2,4]
            if(map.containsKey(x)) map.get(x).add(strs[i]); //check if the sorted like array of present get the list and add
            else {
                ArrayList<String> y = new ArrayList<String>();
                y.add(strs[i]);
                map.put(x , y);
            }
        }
        result.addAll(map.values()); 
        return result;
    }
}