// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this :
//Understand the inner for loop conditition that "i<size-1"
// Your code here along with comments explaining your approach
//1. Create a curr and next interval. 
//2. Traverse through current interval and find the next greatest interval.
//3. Move to the next interval and increment the jump count.

class Solution {
public:
    int jump(vector<int>& nums) {
        //edge
        if(nums.size()==0 || nums.size()<2)
            return 0;
        
        //logic
        int currInterval = nums[0];
        int NextInterval = currInterval;
        int size = nums.size();
        int i =1; int jumps=1;
        while(i<size){
            NextInterval = max(NextInterval, i+nums[i]);
            if(i<size-1 && i == currInterval){
                currInterval = NextInterval;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
};
