/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/jump-game-ii/

class Solution {
public:
    int jump(vector<int>& nums) {
        int jmp=0, mj=0, count=0, n=nums.size();
        for(int i=0;i<n-1;i++) {
            jmp = max(jmp,i+nums[i]);
            if(jmp >= n-1) {
                return count+1;   
            }
            
            if(i==mj) {
                mj = jmp;
                count++;
                jmp = 0;
            }
        }
        
        return count;
    }
};