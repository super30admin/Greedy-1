// Approach - Greedy
// Time Complexity - O(n)
// Space Complexity - O(1)
// It runs on Leetcode!
// Problems Faced - No!

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n < 2)
            return 0;
        
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        
        for(int i = 1; i <= n-1; i++){
            nextInt = max(nextInt, nums[i] + i);
            if(i == currInt && i != n-1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
};
// Attempt2
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2)
            return n-1;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        
        for(int i = 0; i < n; i++){
            nextInt = max(nextInt, nums[i]+i);
            if(i == currInt && i != n-1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
};

// Approach - BFS
// Time Complexity - it is exponential.
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n < 2)
            return 0;
        int jumps = 0;
        queue<int> q;
        set<int> set;
        q.push(0);
        set.insert(0);
        
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int currIdx = q.front(); q.pop();
                if(currIdx >= n-1)
                    return jumps;
                for(int j = 0; j <= nums[currIdx]; j++){
                    int idx = j + currIdx;
                    if(!set.count(idx)){
                        q.push(idx);
                        set.insert(idx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
};
// BFS - Attempt 2
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2)
            return n-1;
        queue<int> myQ;
        myQ.push(0);
        int jumps = 1;
        set<int> mySet;
        
        while(!myQ.empty()){
            int size = myQ.size();
            for(int k = 0; k < size; k++){
                int curr = myQ.front(); myQ.pop();
                for(int i = 0; i < nums[curr]; i++){
                    if(curr + i + 1 == n-1)
                        return jumps;

                    if(!mySet.count(curr + i + 1)){
                        myQ.push(curr + i + 1);
                        mySet.insert(curr + i + 1);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
};

// Approach - DFS

class Solution {
    int minimum = INT_MAX;
    private:
    void dfs(vector<int>& nums, int idx, int jumps){
        // base
        if(idx >= nums.size() - 1){
            minimum = min(minimum, jumps);
            return;
        }
        
        // logic
        for(int i = 1; i <= nums[idx]; i++){
            int currIdx = idx + i;
            dfs(nums, currIdx, jumps+1);
        }
    }
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n < 2)
            return 0;
        dfs(nums, 0, 0);
        return minimum;
    }
};

// Attempt 2 - DFS
class Solution {
    void dfs(vector<int>& nums, int idx, int jumpN, int& jumps){
        // base
        if(jumpN > jumps)
            return;
        if(idx >= nums.size()-1){
            if(jumpN < jumps)
                jumps = jumpN;
            return;
        }
        // logic
        for(int i = 0; i < nums[idx]; i++)
            dfs(nums, idx + i + 1, jumpN+1, jumps);
    }
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2)
            return n-1;
        int jumps = INT_MAX;
        dfs(nums, 0, 0, jumps);
        return jumps;
    }
};

