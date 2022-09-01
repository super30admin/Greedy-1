//Time Complexity:O(n).
//Space Complexity: O(n).


class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0; 
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        int jumps = 0; // maintains the size
            
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                for(int j = 1; j <= nums[curr]; j++){
                int idx = curr + j;
                if(idx >= nums.length - 1) return jumps+1;
                if(!visited.contains(idx)){
                    visited.add(idx);
                    queue.add(idx);
                }
               }
            }  
        jumps++;
    }
        return 890000;
 }
}