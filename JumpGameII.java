package Dec23;

class JumpGameII {
    
    public int jump(int[] nums) {
        
        /*
        Time complexity: O(n)
        
        Approach:
        Greedy approach
        
        Find farthest point one can jump from every element in the given array.
        Find local maximum point in the array.
        
        2                  3   4   1   4   1
        |                 _______  
        currInt
        nextInt
        
        i iterates through index 1 to len-1 
        when i reaches end of currInt range, reset currInt to nextInt and increment jump by 1 since we have found local maximum and now, we need to start looking for jumps from that maximum index.
        */
        
        //edge
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int currInt = nums[0]; // range of elements which is possible to reach after hopping from current element 
        int nextInt = nums[0]; // nextInt is the future currInt in subsequent iterations
        int jumps = 1;
        int n = nums.length;
        
        for(int i = 1; i < n; i++) {
            nextInt = Math.max(nextInt, nums[i] + i);
            if (currInt >= n) {
                break;
            }
            if (i < n - 1 && i == currInt) {
                currInt = nextInt;
                jumps++;
            }
        }
        
        return jumps;
    }
}