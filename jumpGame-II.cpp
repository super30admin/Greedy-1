// Time Complexity : O(n) since we jump on to next stair of next ladder -  
// Space Complexity : O(1) 
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. We maintain two variables currStop and nextStop; currStop indicates where curr ladder will end; nextStop indicates longest ladder we'll next hop on after curr ends
// 2. We move on curr ladder (till currStop) and keep updating nextStop by calculating i+nums[i]
// 3. Once we reach end of current ladder, just increment the iterator and nextStop would have been updated already
// 4. Once currStop reaches last element implies we found the quickest path; if nextStop doesn't update before curr ladder is over implies there is no way to reach the end 

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()<2)
            return 0;
        int currStop=nums[0], nextStop=nums[0], i=0;
        int jump=1; // 
        while(currStop<nums.size()-1){
            for(;i<=currStop;i++){
                nextStop = max(nextStop, i+nums[i]);
            }
            if(currStop == nextStop) // no path found
                return -1;
            jump++;
            currStop = nextStop;
        }
        return jump;
    }
};