class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long massL = mass;
        Arrays.sort(asteroids);
        for(int i = 0; i < asteroids.length ; i++){
            if(massL >= asteroids[i]) massL += asteroids[i];
            else return false;
        }
        return true;
    }
}