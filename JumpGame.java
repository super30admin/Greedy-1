class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
    private boolean dfs(int[] nums, int index){
        //base
        if(index == nums.length - 1) return true;
        
        //logic
        for(int i = 1; i <= nums[index]; i++){
            if(dfs(nums, index+i)) return true;
        }
        return false;
    }
}
//TC: O(n)
//SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}
