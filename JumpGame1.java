import java.util.*;

public class JumpGame1 {


    // Start from second last index.
    // From the current index if can cross the the destination by adding the jumps. ( if it crosses also fine as we can jump by 1 step)
    // Update the current destination.
    // And do the same process.

    //TC:O(N) We are iterating the entire array only once.
    //SC:O(1) We are not using any extra space for calculation.
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        int destination = nums.length-1;
        for(int i=nums.length-2;i>=0;i--) {
            if(i+nums[i] >= destination) {
                destination = i; 
            }
            if(destination == 0) return true;
        }
        return false;
    }

     //BFS
    //Start from 0th index, try with all steps. (example) 0, 1,2 etc.
    // Poll and do the same process and again and again until we hit the last index.
    public boolean canJumpBFS(int[] nums) {
        HashSet<Integer> visited = new HashSet<Integer>();
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        Queue<Integer> queue = new LinkedList(); // Add indices
        visited.add(0);
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int index = queue.poll();            
            for(int i=1;i<=nums[index];i++) {
                int newIndex = i+index;
                if(newIndex == nums.length - 1) return true;
                if(!visited.contains(newIndex)) {
                    visited.add(newIndex);
                    queue.add(newIndex);    
                }
            }
        }
        return false;
    }


    //DFS
    //Explore next next path and check if it reached the end or not.
    //Then try with next jump.
     HashSet<Integer> visited;
    public boolean canJumpDFS(int[] nums) {
        if(nums.length == 1)return true;
        visited = new HashSet<Integer>();
        return helper(nums, 0);
    }
    
    
    private boolean helper(int[] nums, int position) {
        //base
        
        if(position == nums.length-1) {
            return true;
        }
        visited.add(position);
        //logic
        for(int i=1;i<=nums[position];i++) {
            int nextPosition = position+i;
            if(!visited.contains(nextPosition) && helper(nums, nextPosition)) {                     return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
