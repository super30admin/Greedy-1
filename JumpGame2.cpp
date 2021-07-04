/*
Intuition: Keep a track of maxDistance, once we reach the maxDistance, we jump.

Time Complexity: O(N), N = Size of array
Space Complexity: O(1)
*/

//BFS
class Solution {
public:
    int jump(vector<int>& nums) {
        queue<int>queue;
        int min = 0;
        queue.push(0);
        set<int>visited;
        visited.insert(0);
        while ( queue.size()!= 0){      
            int size = queue.size();
            for ( int i = 0; i < size; i++){
                int curr = queue.front();
                queue.pop();
                if ( curr == nums.size() - 1) return min;          
                for ( int jump = 1; jump <= nums[curr]; jump++){
                    
                    if ( curr + jump == nums.size() - 1) return min+1;
                    
                    if ( visited.find( curr + jump) == visited.end()){
                    
                        queue.push(curr+jump);
                        visited.insert(curr+jump);
                    }
                }  
            }
            min++;
   
        }
        return min;
    }
};

//DFS
class Solution {
public:
    int currMin;
    int jump(vector<int>& nums) {
        currMin = INT_MAX;
        dfs( nums, 0, 0);
        return currMin;
    }
    
    void dfs( vector<int> & nums, int index, int jumps){
        
        if ( index >= nums.size() - 1) { 
            currMin = min( currMin,  jumps);
            return;

        }

        for ( int jump = 1; jump <= nums[index];jump++){
    
            dfs(nums, jump + index,jumps+1);
                            
        }
  
    }
};

//O(N)
class Solution {
public:
    int jump(vector<int>& nums) {
        if ( nums.size() < 2) return 0;
        int jump = 1;
        
        int maxDistance = nums[0];
        int curr = nums[0];
        for ( int i = 1; i < nums.size(); i++){
        
            maxDistance = max( maxDistance, i + nums[i]);
            if ( i < nums.size() -1 and curr == i){
                
                
                curr = maxDistance;
                jump++;
            }
        
        
        }
        
        
        return jump;
    }
};