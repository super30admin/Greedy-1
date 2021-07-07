// 45.
class Solution {
    
    int minJumps;
    
    public int jump(int[] nums) {
        //edge
        if(nums == null || nums.length < 2)
        {
            return 0;
        }
        
        // minJumps = Integer.MAX_VALUE;
        // dfs(nums, 0, 0); //start from index 0 with 0 jumps so far
        // return minJumps;
        
        //return minJumpsDP(nums);
        return minJumpsGreedy(nums);
    }
    
    //time - exponential - O(max number in nums[] ^ length of nums[])
    //space - O(length of nums[])
    private void dfs(int[] nums, int index, int jumps) {
        //base
        if(index >= nums.length - 1)
        {
            //valid path to reach end
            minJumps = Math.min(minJumps, jumps); //update result
            return;
        }
        //logic
        for(int i = 1; i <= nums[index]; i++)
        {
            //at the given index, a jump of magnitude 1 to value in that index can be made
            //try all possiblities by increasing jump by 1
            dfs(nums, index + i, jumps + 1);
        }
    }
    
    //time - O(n^2)
    //space - O(n)
    private int minJumpsDP(int[] nums)
    {
        int[] result = new int[nums.length]; //each index tracks min jums to reach that index from 0th index
        int[] path = new int[nums.length]; //each index tracks the index from which the current has to be reached 
        
        Arrays.fill(result, Integer.MAX_VALUE); //initially jumps to reach any i from 0 is infinity
        result[0] = 0; //jumps to reach 0 from 0 is 0
        
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                //check if i is reachable from j
                if(j + nums[j] >= i)
                {
                    //# of jumps to reach i from 0 is # of jumps to reach j from 0 plus 1 as i is reachable from j
                    if(result[i] > 1 + result[j])
                    {
                        result[i] = 1 + result[j]; //update result[i]
                        path[i] = j; //i is reachable from j
                    }
                }
            }
        }
         
        String jumpPath = ""; //path in reverse order
        int current = nums.length - 1; //start from end
        while(current != 0)
        {
            jumpPath += current + " -> "; //add end to path
            current = path[current]; //update current to index stored in path[] of current
        }
        jumpPath += "0"; //add 0 to end
        System.out.println(jumpPath);
        
        return result[nums.length - 1];
    }
    
    //time - O(n)
    //space - O(1)
    private int minJumpsGreedy(int[] nums) {
        int currentStairs = nums[0];  
        int currentLadder = nums[0]; //maximum index reachable initially 
        int jumps = 1; //initially jump from 0 to any possible index within currentladder
        for(int i = 1; i < nums.length; i++)
        {
            if(i == nums.length - 1) //end is reached - return jumps
            {
                return jumps;
            }
            if(i + nums[i] > currentLadder) //found a larger ladder - update current ladder
            {
                currentLadder = i + nums[i];
            }
            currentStairs--; //decrement stairs by 1
            if(currentStairs == 0) //if stairs reaches 0 make a jump to next ladder and start from that position
            {
                jumps++;
                currentStairs = currentLadder - i;
            }
        }
        return 0; //never reaches here as we can always reach end
    }
}
