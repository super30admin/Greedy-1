// Time Complexity : O(n ^n)
// Space Complexity : O(n^n)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Call recursively and explore all the paths
//2. When a path returns true return true. When last index is reached we return true, we cant overshoot
//3. Else return false

class Solution {
public:
    bool canJump(vector<int>& nums) {
        //edge
        if(nums.size()==0 || nums.size()<2)
            return true;
        
        //logic
        return dfs(nums, 0);
    }
    bool dfs(vector<int>& nums, int index){
        //return condition
        //we will never over shoot
        if(index >= nums.size()-1){
            return true;
        }
        //logic
        for(int i=1; i<=nums[index]; i++){
            bool returned = dfs(nums, index+i);
            if(returned ==true){
                return true;
            }
        }
        
        return false;
    }
    
};
// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this : yes
// Your code here along with comments explaining your approach
//1. Greedy approach is taken 
//2. Start from last and change destination if you can set the previous destination from that index
//3. If destination is index "0" at the end then we have path.

class Solution {
public:
    bool canJump(vector<int>& nums) {
        //edge
        if(nums.size()==0 || nums.size()<2)
            return true;
        
        //logic
        int i = nums.size()-2;
        int destination = i+1;
        
        while(i>=0){
            if(i+nums[i]>=destination)
                destination = i;
            i--;
        }
        
        if(destination ==0)
            return true;
        
        return false;
    }
    
};
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Any problem you faced while coding this : 
// Your code here along with comments explaining your approach
//1. DP

class Solution {
public:
    vector<bool> result_index;
    bool canJump(vector<int>& nums) {
        //edge
        if(nums.size()==0 || nums.size()<2)
            return true;
        
        //logic
        result_index.assign(nums.size(), false);
        result_index[nums.size()-1] = true;
        int size = nums.size();
        for(int i=size-2; i>=0; i--){
            int farthest_jump = min(nums[i] , size) ;
            for(int j=1; j<=farthest_jump; j++){
                int index= i+j;
                if(index<size && result_index[index] == true){
                    result_index[i] = true;
                    break;
                }
            }
        }
        return result_index[0];
    }
};
