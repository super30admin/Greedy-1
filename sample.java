//https://leetcode.com/problems/candy
//Time Complexity = O(3N)
//Space Complexity = O(N)

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length; 
        int[] result = new int[n]; 
        Arrays.fill(result, 1); 
        
        //left pass
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1; 
            }
        }
        
        int sum = result[n-1];
        //right pass
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1] + 1); 
            }
            sum = sum + result[i]; 
        }
        return sum;
    }
}
//https://leetcode.com/problems/jump-game-ii/
//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int jumps = 1; 
        int curr = nums[0]; 
        int next = nums[0]; 
        
        for(int i = 1; i < nums.length; i++){
            next = Math.max(next, nums[i] + i); 
            if(i < nums.length - 1 && i >= curr){
                jumps++; 
                curr = next; 
            }
        }
        return jumps;
    }
}

//https://leetcode.com/problems/jump-game/
//Time Complexity = exponential O(m^n)
//Space Complexity = O(N)
//BFS approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int n = nums.length; 
        HashSet<Integer> visited = new HashSet<>(); 
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0); 
        
        while(!q.isEmpty()){
            int curr = q.poll(); 
            for(int j = 1; j <= nums[curr]; j++){
                int idx = curr + j; 
                if(!visited.contains(idx)){
                    if(idx == n - 1) return true;
                    q.add(idx);
                    visited.add(idx);
                }
            }
        }
        return false;
    }
}

//Time Complexity = O(m^n)
//Space Complexity = O(N)
//DFS Approach

class Solution {
    HashSet<Integer> visited; 
    public boolean canJump(int[] nums) {
       visited = new HashSet<>(); 
        if(nums == null || nums.length < 2) return true; 
        return dfs(0,nums);  
    }
    
    private boolean dfs(int idx, int[] nums){
        if(visited.contains(idx)) return false;
        if(idx == nums.length - 1) return true;
        visited.add(idx); 
        for(int i = 1; i <= nums[idx]; i++){
            if(dfs(i + idx, nums)) return true;
        }
        return false;
    }
}

//Time Complexity = O(N)
//Space Complexity = O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int n = nums.length; 
        int destination = n - 1;
        
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] + i >= destination){
                destination = i;
            }
        }
        return (destination == 0);
    }
}
