/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/jump-game/

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        int mj = 0;
        int count =0;
        int jmp=0;
        for(int i=0;i<n;i++) {
            jmp = max(jmp, i + nums[i]);
            if(jmp >= n-1 or mj >= n-1) 
                return true;
            
            if(i == mj) {
                if(jmp <= i) return false;
                mj = jmp;
                jmp = 0;
                count++;
            }
        }
        
        return false;
    }
};