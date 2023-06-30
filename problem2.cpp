
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach 1: BFS 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        queue<int>q;
        int lvl = 0;
        unordered_set<int>set;
        q.push(0);
        set.insert(0);
        while(!q.empty())
        {
            int sz = q.size();
            while(sz--)
            {
                int idx = q.front();q.pop();
                if(idx ==n-1){
                    return lvl;
                }
                for(int i = 1;i<=nums[idx];i++){
                    int nextidx = min(idx+i,n-1);
                    if(set.count(nextidx)) continue;
                    q.push(nextidx);
                    set.insert(nextidx);
                }
            }
            lvl++;
        }
        return -1;
    }
};


// Approach:2 Greedy 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int farthest = 0,currEnd = 0;
        int jumps = 0;
        for(int i=0;i<n-1;i++)
        {
            farthest = max(farthest,i+nums[i]);
            if(i==currEnd){
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }
};