class Solution {
    public String intToRoman(int num) {
        HashMap<Integer , String> map = new HashMap<>();
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        map.put(1 , "I");
        map.put(5 , "V");
        map.put(10 , "X");
        map.put(50, "L");
        map.put(100 , "C");
        map.put(500, "D");
        map.put(1000 , "M");
        map.put(4 , "IV");
        map.put(9 , "IX");
        map.put(40 , "XL");
        map.put(90 , "XC");
        map.put(400 , "CD");
        map.put(900 , "CM");
        StringBuilder sol = new StringBuilder();
        while(num != 0){
            int min = -1;
            for(int v: values){
                if(min == -1 && v <= num) min = v;
            }
            sol.append(map.get(min));
            num -= min;
        }
        return sol.toString();
    }
}