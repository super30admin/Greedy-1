/*
class Solution:
    def jump(self, nums: List[int]) -> int:
        if nums is None or len(nums) < 2:
            return 0
        
        curInterval = nums[0]
        nextInterval = nums[0]
        jumps = 1
        for i in range(1, len(nums)-1):
            if nums[i]+i > nextInterval:
                nextInterval = nums[i]+i
                
            if i == curInterval:
                curInterval = nextInterval
                jumps += 1
                
            if curInterval >= len(nums)-1:
                break
        
        return jumps


*/

// time - O(n)
// space - O(1)
// logic - maintained two intervals and everytime current index comes to current interval then we update the interval and increment jump
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        
        int jumps = 1, curInterval = nums[0], nextInterval = nums[0];
        
        for (int i=1; i<nums.length-1; i++){
            nextInterval = Math.max(nextInterval, nums[i]+i);
            
            if (i == curInterval){
                curInterval = nextInterval;
                jumps  ++;
            }
            if (curInterval >= nums.length-1)
                break;
        }
        return jumps;
    }
}