class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public boolean canJump(int[] nums) {
        
        int destination = nums.length-1;

        for (int i =nums.length-2;i >=0;i--){
            if (i+nums[i] >= destination)
            destination = i;
        }
        return destination ==0;
    }
}
