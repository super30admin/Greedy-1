/*
The time complexity is O(N) and the space complexity is O(1) where N is the size of nums array.

Here the intuition is to start from index 0 and make the highest jump it can have as both curr and next. Till the i pointer reaches curr
we need to see if there is any index in between that can go beyond next. After reaching the curr make the curr as next and increase jump.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if(length==1){return 0;}
        int curr = nums[0];
        int next = nums[0]; int jump = 1;
        for(int i=1;i<length;i++){

            //Check if the curr reached array last or beyond it.
            if(curr>=length-1){
                return jump;
            }
            else if(i==curr){

                //When we reach curr see the last time if we can go beyond next. Then update the curr to next.
                next = Math.max(i+nums[i],next);
                curr = next;
                jump = jump+1;
            }
            else{
                // if we found any from where we can go beyond next update it.
                next = Math.max(i+nums[i],next);
            }
        }

        return jump;
    }
}