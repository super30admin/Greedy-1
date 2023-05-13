//Time -> O(n)
//Space -> O(1)
public class Problem2 {
        public int jump(int[] nums) {
            if(nums.length < 2)
                return 0;
            int currInt = nums[0];
            int nextInt = nums[0];
            int count = 1;
            for(int i = 0; i < nums.length; i++){
                nextInt = Math.max(nextInt, i + nums[i]);
                if(i == currInt){
                    count++;
                    currInt = nextInt;
                }
                if(currInt == nums.length - 1)
                    return count;
            }
            return count;
        }
}
