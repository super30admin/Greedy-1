//TC: O(n)
//SC: O(1)
//approach: greedy, one iteration keeping current maximum
public class JumpGame2Greedy {
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1) return 0;
        int currMax=nums[0];
        int nextMax=nums[0];
        int jumps=1;
        for(int i=1;i<nums.length;i++)
        {
            nextMax= Math.max(i + nums[i], nextMax);
            if(currMax==i && i!=nums.length-1)
            {
                currMax=nextMax;
                jumps++;
            }
            if(currMax>= nums.length-1)
                break;
        }
        return jumps;
    }
}
