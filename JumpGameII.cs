// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int Jump(int[] nums) {
        
    //if there is no element or 1 element, return true, because we are already on last index
    if(nums == null || nums.Length < 2)
        return 0;
    
    int jumps = 1;
    int currInterval = nums[0], nextInterval = nums[0];
    
    for(int i = 0; i < nums.Length; i++)
    {
        //we need to maximize the next interval
        nextInterval = Math.Max(nextInterval, i + nums[i]);
        
        //this is to optimze because next interval already reached last index
        //we dont need to traverse more, we can return jumps+1;
         if(currInterval < nextInterval && nextInterval >= nums.Length - 1)
                return jumps+1;
        else if(nextInterval >= nums.Length - 1)
            return jumps;
        
        //we need to check i < length -1, because we dont need to take jump from last index
        //we reached to current interval, take another jump and update current interval to next interval
        if(i < nums.Length - 1 && i == currInterval)
        {
            jumps++;
            currInterval = nextInterval;
        }
    }
    return jumps;
}


//brute force BFS
HashSet<int> visited;
public int Jump(int[] nums) {
        
    //if there is no element or 1 element, return true, because we are already on last index
    if(nums == null || nums.Length < 2)
        return 0;
    
    visited = new HashSet<int>();   
    return bfs(nums);
}
private int bfs(int[] nums)
{
    Queue<int> queue = new Queue<int>();
    queue.Enqueue(0);
    int level= 0;
    visited.Add(0);
    
    //BFS
    while(queue.Count > 0)
    {
        int currIndex = queue.Dequeue();
        for(int i = 0; i < currIndex; i++)
        {
            var curr = queue.Dequeue();
            int jumps = nums[curr];
            for(int j = 1; j <= jumps; j++)
            {
                int newIndx = j + curr;
                if(newIndx >= nums.Length - 1)
                    return level + 1;
                if(!visited.Contains(newIndx))
                {
                    queue.Enqueue(newIndx);
                    visited.Add(newIndx);
                }
            }
        }
        level++;
    }
    return level;
}