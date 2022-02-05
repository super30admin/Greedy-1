import java.util.*;f

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        //o(n) time and o(n) space
        if(ratings == null || ratings.length ==0) return 0;
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }
            
        }
        int result = res[ratings.length-1];

        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[ i+1]){
                res[i] = Math.max(res[i], res[i+1] +1);
            }
            result+= res[i];
        }
        return result;
    }
    public boolean canJump(int[] nums) {
        //o(n) time and const space
        if(nums == null || nums.length == 0) return false;
           int dest = nums.length -1;
           for(int i = nums.length - 2; i>=0; i--){
               
               if(nums[i] + i >= dest){
                   dest = i;
               }
           }
           
           return dest == 0;
           
       }

        public int jump(int[] nums) {
                    //o(n) time and o(n) space

            if(nums == null || nums.length == 0) return 0;
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            int count = 0;
            q.add(0); visited.add(0);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i <size; i++){
                    int idx = q.poll();
                    if(idx >= nums.length -1) return count;
                    for(int jump = 1; jump <= nums[idx]; jump++){
                        if(!visited.contains(jump + idx)){
                            q.add(jump + idx);
                            if(idx + jump >= nums.length -1) return count+1;
    
                            visited.add(jump+idx);
                            
                        }
                    }
                }
                count++;
                
            }
            return count+1;
    
        }
    

    
}

