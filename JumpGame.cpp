// Approach - Greedy
// Time Complexity - O(n)
// Space Complexity - O(1)
// It runs on Leetcode!
// Problems Faced - No!
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)
            return true;
        int target = n-1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] + i >= target)
                target = i;
        }
        return target == 0;
    }
};

// Approach - BFS
// Time Complexity - exponential
// Attempt 1
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)
            return true;
        queue<int> q;
        q.push(0);
        
        while(!q.empty()){
            int currIdx = q.front(); q.pop();
            for(int j = 1; j <= nums[currIdx]; j++){
                int idx = currIdx + j;
                if(idx >= n-1)
                    return true;
                q.push(idx);
            }
        }
        return false;
    }
};
// Attempt 2
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() == 1)
            return true;
        queue<int> myQ;
        myQ.push(0);
        int target = nums.size() - 1;
        while(!myQ.empty()){
            int idx = myQ.front();
            int times = nums[idx]; myQ.pop();
            for(int i = 0; i < times; i++){
                if(idx + nums[idx] >= target)
                    return true;
                myQ.push(idx + i + 1);
            }
        }
        
        return false;
    }
};


// Approach - Optimised BFS
// Time Complexity - O(n^2)
// Space Complexity - O(n)
// Problems Faced - Still gives me a TLE
// Attempt 1
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)
            return true;
        queue<int> q;
        set<int> set;
        q.push(0);
        set.insert(0);
        
        while(!q.empty()){
            int currIdx = q.front(); q.pop();
            for(int j = 1; j <= nums[currIdx]; j++){
                int idx = currIdx + j;
                if(idx >= n-1)
                    return true;
                if(!set.count(idx))
                {   q.push(idx);
                    set.insert(idx);   
                }
            }
        }
        return false;
    }
};
// Attempt 2
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() == 1)
            return true;
        set<int> mySet;
        queue<int> myQ;
        myQ.push(0);
        int target = nums.size() - 1;
        while(!myQ.empty()){
            int idx = myQ.front(); myQ.pop();
            for(int i = 0; i < nums[idx]; i++){
                if(idx + nums[idx] >= target)
                    return true;
                if(!mySet.count(idx + i + 1)){
                    myQ.push(idx + i + 1);
                    mySet.insert(idx + i + 1);
                }
            }
        }
        
        return false;
    }
};


// Approach - DFS
class Solution {
    private:
    bool dfs(vector<int>& nums, int idx){
        // base
        if(idx >= nums.size() - 1)
            return true;
        
        // logic
        for(int j = 1; j <= nums[idx]; j++){
            int newIdx = j + idx;
            if(dfs(nums, newIdx))
                return true;
        }
        return false;
    }
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return true;
        return dfs(nums, 0);
    }
};

// Approach - DFS(void function)
class Solution {
    void dfs(vector<int>& nums, bool& flag, int index){
        // base
        if(index >= nums.size()-1){
            flag = true;
            return;
        }
            
        // logic
        for(int i = 0; i < nums[index]; i++)
            dfs(nums, flag, index + i + 1);
        
    }
public:
    bool canJump(vector<int>& nums) {
        bool flag = false;
        dfs(nums, flag, 0);
        return flag;
    }
};