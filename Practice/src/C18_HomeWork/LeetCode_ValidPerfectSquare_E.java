package C18_HomeWork_LeetCode;
 
public class LeetCode_ValidPerfectSquare_E {
    public static void main(String[] args){

        for(int i=0;i<2000;++i){
            System.out.println(i + "\t" + isPerfectSquarePRO(i));
        }
//        for(int i=0;i<4000;++i){
//            if(IsPerfectSquare(i)){
//                System.out.println(i + "\t" + IsPerfectSquare(i));
//            }
//            //System.out.println(i + "\t" + IsPerfectSquare(i));
//        }
    }

    public static boolean isPerfectSquarePRO(int number) {
        if(number <= 0)                 return false;
        if(number == 1 || number == 4)  return true;

        int left    =   0;
        int right   =   number;

        while(left <= right){
            int middle  =   left + (right - left)/2;

            if(middle * middle == number) return true;
            else if(middle > number/middle) right = --middle;
            else left = ++middle;
        }
        return false;
    }

    public static boolean IsPerfectSquare(int num){
        if(num <= 0)                return false;
        if(num == 1 || num == 4)    return true;

        int temp = 0;
        int resolution = 1;
        int[] details = digitNumerMinusOne(num);
        //System.out.println(num + "\t" + "numberOfDigits, limit = numberOfDigits-1, tenLevel");
        //System.out.println(num + "\t" + details[0] + ", " + details[1] + ", " + details[2]);

        if(details[1] < num){
            if(num < 10){
                temp = num/(details[0]+resolution);
            }
            else if(num >= details[2]){
                resolution += (details[0] + details[1]);
                if(resolution * resolution == num){
                    return true;
                }
            }
            temp = num/(resolution+1);
        }

        if(temp*temp == num){
            return true;
        } else {
            int[] array = new int[temp];
            for(int i=0;i<array.length;++i){
                array[i] = i;
            }
            int x = binarySearch(array,num);
            if(x * x == num){
                return true;
            }
        }


        return false;
    }
    private static int[] digitNumerMinusOne(int nr){
        //  content[] = {numberOfDigits , limit = numberOfDigits-1 , tenLevel}
        int[] content = new int[3];
        int numberOfDigits = 0;
        int tenLevel = 1;
        while(nr != 0){
            ++numberOfDigits;
            tenLevel *=10;
            nr/=10;
        }
        content[0]  =   numberOfDigits;
        content[1]  =   --numberOfDigits;
        content[2]  =   tenLevel/10;
        return content;
    }
    private static int binarySearch(int[] array,int target){
        int left    =   0;
        int right   =   array.length-1;


        while(left <= right){
            int middle  =   left + (right - left)/2;
            int prod = array[middle] * array[middle];
            if(prod == target) return array[middle];
            if(target < prod)  right = --middle;
            else left = ++middle;
        }
        return -1;
    }

}

