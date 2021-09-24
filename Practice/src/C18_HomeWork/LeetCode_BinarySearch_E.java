package C18_HomeWork_LeetCode;
  
public class LeetCode_BinarySearch_E {
    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int nr = 10;
        System.out.println("Numarul " + nr + " se afla pe poz " + binarySearch(nums,nr));
    }

    public static int binarySearch(int[] array, int target){
        int left    =   0;
        int right   =   array.length-1;

        while(left <= right){
            int middle  =   left + (right - left)/2;
            if(target == array[middle]) return middle;
            if(target < array[middle])  right = --middle;
            else left = ++middle;
        }
        return -1;
    }
}
