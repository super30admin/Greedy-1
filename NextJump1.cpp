#include<iostream>
#include<stack>
#include<algorithm>
#include<vector>
using namespace std;

// Time Complexity : O(N) for Greedy Approach,O(N^2) for DP
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach

/**
 * This approach is based on Greedy Algos.It can be solved using DP in top down manner
 * But DP Approach explores all possibilities,memoize them and then present the result.
 * Since this problem asks whether it is possible to reach the last index.DP can be overkill for this problem.
 * 
 * Greedy Algo can be used for this problem since it explore the maximum number of steps to reach 
 * the problem.We will solve problem in bottom up manner
 * 
 * We start iteration of array in reverse direction
 * Let dest = last element of array
 * for i in (1,array.length)
 *    if i + array[i] >= dest
 *      dest = i
 * 
 * Check dest == 0
 *  if True then we have reached first element of array i.e
 *  It is possible to reach last element
 *  if False   we have not reached first element of array i.e
 *  It is possible to reach last element
 *  
 */
bool canJump(vector<int>& nums) {
        int last = nums.size() -1;
        for(int i = nums.size() - 1; i >= 0; i--){
            if(nums[i] + i >= last){
                last = i;
            }
        }
        return last == 0;
    }


int main(){
    vector<int> nums = {2,3,1,4,4};
    cout<<canJump(nums);
}
