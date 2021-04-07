class Solution {
//     public boolean canJump(int[] nums) {
        
//         if(nums == null || nums.length == 0)return false;
        
//         //return dfs(nums,0);
        
//         Queue<Integer> queue = new LinkedList<>();
        
//         HashSet<Integer> visited = new HashSet<>();
//         //visited.add(0);
//         queue.add(0);
        
//         while(!queue.isEmpty()){
//             int index = queue.poll();
            
//             int jumps = nums[index];
            
//             if(index >= nums.length-1)return true;
            
//             for(int i = 1; i <= jumps;i++){
//                 queue.add(index+i);
//                 //visited.add(index+i);
//             }
//         }
//         return false;
//     }
    
//     private boolean dfs(int[]nums, int index){
        
//         if(index >= nums.length-1)return true;
        
        
//         for(int jump = 1; jump <= nums[index];jump++){
//             if(dfs(nums, index+jump)){
//                 return true;
//             }
//         }
//         return false;
//     }
    
    
    //greedy technique - TC:O(n)
    public boolean canJump(int[] nums){
        
        if(nums.length == 0 || nums == null){
            return false;
        }
        
        int dest = nums.length-1;
        
        for(int i = nums.length-2; i >= 0; i--){
            if(i + nums[i] >= dest){
                //update the destination here
                dest = i;
            }
        }
        
        if(dest == 0){
            return true;
        }
        return false;
    }
 }
    