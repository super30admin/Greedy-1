
// time - O(N)
// space - O(1)



class Solution {
    public boolean canJump(int[] nums) {

        if(nums == null || nums.length < 2) return true;
        int n = nums.length;

        int destination = n - 1; // we store destination element as the last one

        for(int i = n-2; i >= 0; i--) {

            if(nums[i] + i >= destination) { // if the previous element + index is more theen destination then we can reach the destination
                destination = i; // store ith value to destination
            }

        }

        return destination == 0; // if the destination is equal to the first index then we ofund thee path from start to finish

    }
}