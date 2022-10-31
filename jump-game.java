//Time O(N)
//Space O(1)
class Solution {
    public boolean canJump(int[] nums) {
        
        //we dont have to reach the last element 
        //we just have to reach the element before it(if second last can reah last)
        int goal = nums.length-1;
        
        for(int i= goal;i>=0;i--){
            if(i + nums[i] >= goal)
                goal =i;
        }
        
        //we can reach final from start
        if(goal==0)
            return true;
        else 
            return false;
    }
}