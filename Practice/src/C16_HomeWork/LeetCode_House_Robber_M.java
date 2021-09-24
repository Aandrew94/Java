package C16_HomeWork_LeetCode;

public class LeetCode_House_Robber_M {
    public static void main(String[] args){
        int[]   test1   =   {1,2,3,1};
        int[]   test2   =   {2,7,9,3,1};
        int[]   test3   =   {2,1,1,2};
        int[]   test4   =   {1,3,1};


        System.out.println("TEST 1");
        System.out.println(rob(test1));

        System.out.println("\nTEST 2");
        System.out.println(rob(test2));

        System.out.println("\nTEST 3");
        System.out.println(rob(test3));

        System.out.println("\nTEST 4");
        System.out.println(rob(test4));

    }

    public static int rob(int[] nums) {
        int nextMoney = nums[0];

        if(nums.length>1){
            int skipMoney = nums[nums.length-1];
            int nextNewMoney = 0;

            if(nums[nums.length-1] > nums[nums.length-2]){
                nextMoney = nums[nums.length-1];
            } else {
                nextMoney = nums[nums.length-2];
            }

            for(int i=nums.length-3; i>-1; i--) {
                int sum = nums[i] + skipMoney;
                if(sum > nextMoney){
                    nextNewMoney = sum;
                } else {
                    nextNewMoney = nextMoney;
                }
                skipMoney = nextMoney;
                nextMoney = nextNewMoney;
            }
        }

        return nextMoney;
    }

}
