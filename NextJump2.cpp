#include<iostream>
#include<stack>
#include<algorithm>
#include<vector>
using namespace std;

// Time Complexity : O(N) for Greedy,O(N^2) for DP
// Space Complexity : O(N) for DP,O(1) for Greedy
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach

int jumpDP(vector<int>& arr){
    vector<int> jump(arr.size());
        jump[0] = 0;
        for(int i=1; i < arr.size() ; i++){
            jump[i] = INT_MAX -1;
        }
        
        for(int i=1; i < arr.size(); i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        return jump[jump.size()-1]; 
}

int jump(vector<int>& nums) {
     int n = nums.size();
    if (n < 2) return 0;

    // max position one could reach 
    // starting from index <= i 
    int maxPos = nums[0];
    // max number of steps one could do
    // inside this jump
    int maxSteps = nums[0];
    
    int jumps = 1;
    for (int i = 1; i < n; ++i) {
      // if to reach this point 
      // one needs one more jump
      if (maxSteps < i) {
        ++jumps;
        maxSteps = maxPos;
      }
      maxPos = max(maxPos, nums[i] + i);
    }
    return jumps;  
}

int main(){
    vector<int> nums = {2,3,1,1,4};
    cout<<jump(nums);
    cout<<jumpDP(nums);
}