/*Running Time Complexity: o(n)
Space Complexity: constant
Successfully Run and Compiled on leetcode
*/
class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=destination){
                destination = i;
            }
        }
    return destination == 0;
    }
}
//BFS solution which is comparatively slower then upper solution 
class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0); visited.add(0);
        while(!q.isEmpty()){
            int idx = q.poll();
            if(idx==nums.length-1) return true;
            for(int i=1;i<=nums[idx];i++){
                if(!visited.contains(idx+i)){
                    q.add(idx+i);
                    if(idx+i==nums.length-1) return true;
                    visited.add(idx+i);
                }
                
            }
        }
        return false;
        
    }
}
//Dfs Solution 
class Solution {
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        visited = new HashSet<>();
        return dfs(nums,0);
    }
    private boolean dfs(int[] nums, int index){
        //base 
        if(index==nums.length-1) return true;
        
        //Logic
        visited.add(index);
        for(int i = 1;i<=nums[index];i++){
            if(!visited.contains(index+i) && dfs(nums,index+i)) return true;
        }
        return false;
    }
}