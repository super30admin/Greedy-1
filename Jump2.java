//BruteForce

class Solution {
    //Time Exponetial
    //Space O(H)
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return 0;
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] {0,0});
        int min = Integer.MAX_VALUE;
        while(!Q.isEmpty())
        {
            int index[] = Q.poll();
            if(index[0] >= nums.length-1)
            {
                min = Math.min(min , index[1]);
            }
            else
            {
                for(int jump=1 ; jump<=nums[index[0]] ; jump++)
                {
                        Q.add(new int[] {jump+index[0] , index[1]+1});
                }
            }
            
        }
        return min;
    }
}

//Optimized
class Solution {
    //Time O(N)
    //Space O(1)
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return 0;
        }
        int Next = nums[0] , curr = nums[0] , jump = 1;
        for(int i=1 ; i<nums.length ; i++)
        {
            Next = Math.max(Next , i+nums[i]);
            if(i < nums.length-1 && curr == i)
            {
                curr = Next;
                jump++;
            }
        }
        return jump;
    }
}