class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs , (a , b) -> {
            String[] as = a.split(" ");
            String[] bs = b.split(" ");
            boolean af = Character.isDigit(as[1].charAt(0));
            boolean bf = Character.isDigit(bs[1].charAt(0));
            if(af && !bf) return 1;
            else if(!af && bf) return -1;
            else if(!af && !bf){
                String x = a.substring(as[0].length() + 1);
                String y = b.substring(bs[0].length() + 1);
                int temp = x.compareTo(y);
                return temp == 0 ? as[0].compareTo(bs[0]) : temp;
            }
            return 0;
        });
        return logs;
    }
    public String getFirstPart(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(!Character.isDigit(s.charAt(i))) sb.append(s.charAt(i++));
        return sb.toString();
    }
}