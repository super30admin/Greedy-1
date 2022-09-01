//Time Complexity: O(n).
//Space Complexity: O(n)

class Solution {
    
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true; 
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited  = new HashSet<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            int idx = queue.poll();
            for(int i = 1; i <= nums[idx]; i++){
                int pointer = idx + i;
                if(pointer == nums.length - 1) return true;
                if(!visited.contains(pointer)){
                    visited.add(pointer);
                    queue.add(pointer);
                }
            }  
        }
        return false;
    }
}