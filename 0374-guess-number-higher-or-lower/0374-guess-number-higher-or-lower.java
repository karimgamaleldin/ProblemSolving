/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + ( - left + right) / 2;
            int g = guess(mid);
            if(g == 0) return mid;
            else if(g == 1) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}