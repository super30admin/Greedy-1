// Time Complexity: In worst case O(n)
// Space Complexity: O(1)
// Idea here is to greedily choose from the range of value given at current index
// which gives the next maximum range value
// by moving left to current maximum+1 and right as next max range
// we can identify which element will give max jump once we reach destination count of jumps is returned
class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int left = 0; int right=0;
        while(right<nums.length-1){
            int jump = 0;
            for(int i = left; i<=right; i++){
                jump = Math.max(i+nums[i], jump);
            }
            
            left = right+1;
            right = jump;
            result++;
        }
        return result;
    }
}