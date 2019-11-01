/*
The time complexity is O(N) and the space complexity is O(1) where N is the size of nums array.

The intuition here is to process the nums array from the backwards and see for each index i if we can reach the processed array. If yes
then update the processed index to i.

Yes, the solution passed all the test cases in leet code.
 */
class Solution {
    public boolean canJump(int[] nums) {

        int length = nums.length;
        if(length==0 || (length>1 && nums[0]==0)){return false;}
        else{

            // We know that the last index is already processed.
            int curr = length-1;
            for(int i=length-2;i>=0;i--){

                //Check for each i if the distance between the processed index and i is less than or equal to nums[i]
                if(curr-i<=nums[i]){
                    curr = i;
                }
            }

            //Check if the processed index reaches 0 index.
            return curr==0;
        }
    }
}