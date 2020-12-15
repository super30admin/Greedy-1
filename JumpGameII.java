/*
TC: O(N) - one pass solution
SC: O(1)

*/

public class JumpGameII {
    public int jump(int[] nums){
        int jump = 0, curEnd = 0, curFar = 0;

        for(int i = 0; i < nums.length - 1; i++){
            curFar = Math.max(curFar, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = curFar;
            }
        }
        return jump;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,4,2,3,5,2,2,1};
        JumpGameII game = new JumpGameII();
        System.out.println(game.jump(nums));
    }
}
