class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean x = false;
        for(int i = 0 ; i < bits.length ; i++){
            if(i == bits.length - 1) x = true;
            if(bits[i] == 1) i++;
        }
        return x;
    }
}