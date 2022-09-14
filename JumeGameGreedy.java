// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//add index and element value and see if it's greater than the destination.If it is, destination can be reached. So, update the destination to the current index.
// Repeat this till the the first element. If the destination is 0, it could be reached.
class JumpGameGreedy {
    Set<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;

        int destination = nums.length - 1;
        for(int i = nums.length-2; i >= 0; i--) {
            if(i + nums[i] >= destination) {
                destination = i;
            }
        }
        return (destination == 0);
    }

}