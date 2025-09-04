#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) 
            return true;
        int K = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= K) {
                K = i;
            }
        }
        return K == 0;
    }
};