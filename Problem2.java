//Time : O(n)
//Space:O(1)
//LeetCode:Yes

//Approach:
//1.Make a jump from index 0 and store the max jump position as next position. and current position
//2.Now from index 0 to curpos index check the maximum index that can be reached by jumping max distance . Update nextpos accordingly.
//3.Now ,if jumping from curpos will give a position greater than nextpos,update it accordingly.
//4.On reaching curpos , make another jump,update jump variable and update curpos as nextpos as this will be max distance travelled in min jumps.
//5.Now after each iteration check if curpos is the end position and break from loop and return jumps.
class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1)  return 0;
        int jump = 1;
        int curpos = nums[0];
        int nextpos = nums[0];
        for(int i = 1;i<nums.length;i++){
            nextpos = i+nums[i]>nextpos?i+nums[i]:nextpos;
            if(i == curpos && i!=nums.length-1){
                jump++;
                curpos = nextpos;
            }
            if(curpos>=nums.length-1)
                break;
        }
        return jump;
        
    }
}
