/*
Intuition: Start by bfs or dfs, be exhaustive.

We can also update the desination and check if destination == 0.

Time Complexity: O(N), N = Size of array
Space Complexity: O(1)
*/

//BFS
class Solution {
public:
    bool canJump(vector<int>& nums) {
        queue<int> queue;
        set<int>visited;

        queue.push(0);
        visited.insert(0);
        while ( queue.size() != 0){

            auto idx = queue.front();
            
            if ( idx == nums.size()-1) return true;
            
            queue.pop();
            
            for ( int jump = 1; jump <= nums[idx]; jump++){
                
                if ( jump+idx == nums.size()-1) return true;
                
                if ( visited.find(jump+idx) == visited.end()) {
                    visited.insert(jump+idx);
                    queue.push(jump+ idx);
                }
                
            
            }

        }
        return false;
    }
};

//DFS
class Solution {
public:
    set<int>visited;
    bool canJump(vector<int>& nums) {
        return dfs(0, nums);    
    }

    bool dfs(int index, vector<int>& nums){
        
        if ( index == nums.size()-1) return true;
        if ( visited.find( index) != visited.end()) return false;
        
        visited.insert(index);
        for ( int jump = 1; jump <= nums[index]; jump++){
            if ( dfs(jump+index, nums)) return true;
        }
        return false;
    }
};


//Linear
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int destination = nums.size()-1;
        for ( int i = nums.size() - 2; i >= 0; i--){
            if ( i + nums[i] >= destination )
                destination = i;
        }
        return destination == 0;
        
    }
};