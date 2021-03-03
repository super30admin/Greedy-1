/* brute force 
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) < 2:
            return True
        
        return self.dfs(nums, 0)
    
    def dfs(self, nums, index):
        if index >= len(nums) - 1:
            return True
        
        
        for i in range(1, nums[index]+1):
            if self.dfs(nums, index+1):
                return True
        
        return False


class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        
        return dfs(nums, 0);
        
    }
    private boolean dfs(int[] nums, int index){
        // base
        if (index >= nums.length-1)
            return true;
        
        //logic
         for (int i=1; i<=nums[index]; i++){
             if (dfs(nums, index+i))
                 return true;
         }
        return false;
    }
}
*/
/*
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) < 2:
            return True
        
        destination = len(nums) - 1
        
        for i in range(len(nums)-2, -1, -1):
            if i + nums[i] >= destination:
                destination = i
            
        if destination == 0:
            return True
        
        return False

from jumpII logic
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums is None or len(nums) < 2:
            return True
        
        nextInterval = nums[0]
        
        for i in range(1, len(nums)):
            if i > nextInterval:
                return False
            
            nextInterval = max(nextInterval, nums[i]+i)
                
            if nextInterval >= len(nums)-1:
                return True
        
        return False

        
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        
        int nextInterval = nums[0];
        for (int i=1; i<nums.length; i++){
            if (i > nextInterval)
                return false;
            
            nextInterval = Math.max(nextInterval, nums[i]+i);
            
            if (nextInterval >= nums.length-1)
                return true;
        }
        
        return false;
    }
}
*/

// time - O(n)
// space - O(1)
// logic - started from last and checked whether it is possible to reach last index from second last index if yes then checked whether it is
// possible to reach 2nd last index from 3rd last and so on
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        
        int destination = nums.length - 1;
        for (int i=nums.length-2; i>=0; i--){
            if (i+nums[i] >= destination)
                destination = i;
        }
        if (destination == 0)
            return true;
        
        return false;
    }
}