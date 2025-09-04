#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n==1)
            return 0;
        int maxi = nums[0],curr = nums[0],ans = 1;
        for(int i = 1; i < n; i++) {
            maxi = max(maxi,i+nums[i]);
            if(i != n-1 && i==curr) {
                ans++;
                curr = maxi;
            }
        }
        return ans;
    }
};