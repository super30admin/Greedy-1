/*Running Time Complexity: O(n)
Space Complexity: O(1) or constant
successfully Run and Compiled on leetcode
*/
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        int curr = nums[0]; int next = nums[0];
        int  jump = 1;
        for(int i = 1;i<nums.length;i++){
            next = Math.max(next,i + nums[i]);
            if(i< nums.length - 1 && curr ==i){
                curr = next ;
                jump++;
            }
        }
        return jump;
    }
   
    
}

//Bfs Solution 
class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();
        q.add(0); visited.add(0);
        int jumps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int curr = q.poll();
                if(curr>=nums.length-1) return jumps;
                for(int jump = 1;jump<=nums[curr];jump++){
                    if(!visited.contains(curr+jump)){
                    q.add(curr+jump);
                    if(curr>=nums.length) return jumps;
                    visited.add(curr+jump);
                }
                
                }
            }
            jumps++;
            //System.out.println(q);

        }
        return jumps;
    }
}
//Dfs Solution -> which is giving time limit exceed
class Solution {
    int min;
    public int jump(int[] nums) {
        min = Integer.MAX_VALUE;
        dfs(nums,0,0);
        return min;
    }
    private void dfs(int[] nums,int index, int jump){
        //base case
        if(index >= nums.length-1){
            min = Math.min(min,jump);
            return;
        }
        
        //logic
        for(int i=1;i<=nums[index];i++){
            dfs(nums,index+i,jump+1);    
        }
        
    }
    
}
