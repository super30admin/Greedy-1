// Time Complexity : O(N) # of elements
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Traverse from last element as it is our initial target to jump. 
// 2. Check if we can jump to target from current element if adding it's value and index is greater than target. 
// 3. If we can current element becomes the target. If 0th index is target hence we can reach last element else we can't

class Solution {
public:
    bool dfs(vector<int>& nums,int pt,int &tr){
        if(tr == pt){tr=pt; return true;}
        if(tr < pt){ return false;}

        for(int i=1;i<=nums[pt];i++){
            if(dfs(nums,pt+i,tr)){tr=pt; return true;}
        }
        return false;
    }
    bool canJump(vector<int>& nums) {
        int n=nums.size()-1;
        int tr=n;
        for(int i=n;i>=0;i--){
            if( (i+nums[i]) >= tr){tr=i;}
        }
        if(tr==0){return true;}else{return false;}
    }
};
