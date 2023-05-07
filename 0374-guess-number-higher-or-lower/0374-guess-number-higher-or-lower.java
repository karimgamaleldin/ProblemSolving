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
        int start = 0 ;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start)/2  ;
            if(0 == guess(mid)) return mid;
            else if(1 == guess(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
        
    }
}