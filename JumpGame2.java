public class JumpGame2 {


    //Iterate each number.
    //Greey Thinking:
    //I need to find the next largest value to cover the longest path.
    //So I will first check the first element's next largest landing.
    //Repeat the same process again until we reaches the end.

    //TC: O(N) - Iterating all the elements only once
    //SC: O(1) - Not using any extra space
    public int jump(int[] nums) {

        //Validation
        if(nums == null || nums.length <= 1) return 0;

        int maxJump = nums[0];
        int result = 1;
        int currentElement = nums[0]; 
        for(int i=1;i<nums.length;i++) { // 1
            int jum = i+nums[i]; // 4
            maxJump = Math.max(maxJump, jum);
            if(maxJump == nums.length -1) return result;
            if(maxJump <= nums.length -1 && nums[i] == currentElement) {
                currentElement = nums[i+1];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JumpGame2 jum = new JumpGame2();
        jum.jump(new int[]{2,3,1,1,4,3,4,3});
    }
}
