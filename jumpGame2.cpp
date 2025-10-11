#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a greedy approach to track the farthest index we can jump to at every step.
When we reach the end of the current jump's range, we increment the jump count.
We only increment jumps if we're not already at the last index.
*/
class Solution{
public:
    int jump(vector<int>& nums){
        int n = nums.size();
        if(n == 1) return 0;

        int maxInt = nums[0], currInt = nums[0];
        int jumps = 1;

        for(int i = 1; i < n; i++){
            maxInt = max(maxInt, i + nums[i]);

            if(i != n - 1 && i == currInt){
                jumps++;
                currInt = maxInt;
            }
        }
        return jumps;
    }
};
