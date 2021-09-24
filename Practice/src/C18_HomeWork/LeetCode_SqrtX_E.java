package C18_HomeWork_LeetCode;
 
public class LeetCode_SqrtX_E {

    public static void main(String[] args){
        for(int i=0;i<=30;++i){
            System.out.println("Sqrt("+i+"):\t" + mySqrt(i));
        }
    }

    public static int mySqrt(int num) {
        if(num == 0 || num == 1)    return num;

        int low = 0;
        int high = num;

        while(low <= high){
            int middle = low + (high - low)/2;

            if(middle*middle == num)    return middle;
            else if(middle > num/middle)    high = --middle;
            else low = ++middle;
        }
        return high;
    }
}
