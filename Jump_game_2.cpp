// Time Complexity : O(n) as we are travelling throught the array only once
// Space Complexity : O(1) we are not creating any space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size() == 0 || nums.size() == 1){
            return 0;
        }
        
        int jump = 1;
        
        int curr = nums[0];
        
        int next = nums[0];
        
        
     for( int i = 0; i <nums.size(); i++){
         
         next = ( i + nums[i] >next)? i + nums[i]: next;
         
         if( i == curr){
             jump +=1;
             
             curr = next;
             
         }
         
         if( curr >= nums.size() -1){
             
             break;
         }
         
     }
        return jump;
        
    }
};