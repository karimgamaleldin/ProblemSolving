class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] balon = new int[5];
        for(int i = 0 ; i < text.length() ; i++){
            char c = text.charAt(i);
            int x = indexInArray(c);
            if(x != -1) balon[x]++;
        }
        int words = balon[0];
        words = Math.min(words , balon[1]);
        words = Math.min(words , balon[2] / 2);
        words = Math.min(words , balon[4]);
        words = Math.min(words , balon[3] / 2);
        return words;
        
    }
    public int indexInArray(char x){
        switch(x){
            case 'b': return 0;
            case 'a': return 1;
            case 'l': return 2;
            case 'o': return 3;
            case 'n': return 4;
            default: return -1;
        }
    }
}