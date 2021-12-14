//Timecomplexity:- O(N).
//space complexity:- O(1).
//did it work on leetcode :- Yes.
//Approach with code:- from index0 to destination we take that index value plus array value at index and in between any zero appeared we can return false.
//same but here we follow from backwards and updates destination variable will be updated only when sum of index and a[index]>=destination
//then destination will be updated to i. Like that destination will move and when reaches zero, true can be returned.
class Solution {
    public boolean canJump(int[] nums) {
        int destination=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=destination){
                destination=i;
            }
        }
        if(destination==0){
            return true;
        }
        return false;
    }
}