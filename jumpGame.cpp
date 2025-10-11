#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We start from the end of the array, and iterate through it
We check if the sum of element and the index is greater than the target
we put the index into the target and return target as 0 if their are no ways
*/
class Solution{
public:
    bool canJump(vector<int>& nums){
        int n = nums.size();
        if(n == 1) return true;

        int target = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] + i >= target) target = i;
        }
        return target == 0;
    }
};
