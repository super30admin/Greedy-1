////Brute Force

class Solution {
    //Time Exponetial
    //Space O(H)
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        set.add(0);
        while(!Q.isEmpty())
        {
            int index = Q.poll();
            if(index >= nums.length-1) return true;
            for(int jump=1 ; jump<=nums[index] ; jump++)
            {
                if(!set.contains(jump+index))
                {
                    if(jump+index >= nums.length-1) return true;
                    Q.add(jump+index);
                    set.add(jump+index);
                }
            }
        }
        return false;
    }
}


///Optimized
class Solution {
    //Time O(N)
    //Space O(1)
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return true;
        }
        int destination = nums.length-1;
        for(int i= nums.length-2 ; i>=0 ; i--)
        {
            if(nums[i]+i >= destination)
            {
                destination = i;
            }
        }
        return (destination == 0);
    }
}