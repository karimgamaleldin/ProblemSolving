class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0 ;
        int j = people.length - 1;
        int count = 0;
        while (i <= j){
            int x = people[i];
            int y = people[j];
            j--;
            count++;
            if(x + y <= limit) i++;
        }
        return count;
    }
}