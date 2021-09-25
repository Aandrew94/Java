package W;
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class LeetCode_Guess_Number_Higher_or_Lower_E {
    public static void main(String[] args){
        
    }

    public static int guuessNumber(int n){
        int low = 1;
        int high = n;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int result = guess(middle);
            if (result  ==  0)  return middle;
            if (result  <   0)  high = --middle;
            else                low = ++middle;
        }
        return -1;
    }
}
