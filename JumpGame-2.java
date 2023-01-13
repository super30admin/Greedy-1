
//Time complexity is O(N)
//Space complexity is O(1)
class Solution {
    public int jump(int[] nums) {
        int result=0;
        int max = 0;
        int curr = 0;
        for(int i=0;i<nums.length-1;i++){
            max =Math.max(max, i+nums[i]);
            if(curr==i){
                curr=max;
                result=result+1;
            }
        }
        return result;
    }
}