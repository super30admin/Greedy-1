//Time: O(N)
// Space = O(1)
//traverse from right and start with last element as destination
// find it the element before has the number of jumps to reach the destination
class Solution {
    public boolean canJump(int[] nums) {
        
        int destination = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= destination) {
                destination = i;
            }
        }
        
        return destination == 0;
    }
}
