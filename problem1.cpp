/*
Time complexity: O(n)
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    bool canJump(int A[], int n) {
    int i = 0;
    for (int reach = 0; i < n && i <= reach; ++i)
        reach = max(i + A[i], reach);
    return i == n;
    }
};