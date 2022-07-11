/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class JumpGame
{
    public boolean canJump(int[] nums)
    {
        boolean canJumpBFS = canJumpBFS(nums);

        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean canJumpDFS = canJumpDFS(nums, 0, set);


        return false;
    }

    private boolean canJumpLinear(int nums[])
    {
        if(nums.length == 1)
            return true;

        int target = nums.length -1;

        for(int i = nums.length -2; i >= 0; i--)
        {
            if(i + nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;
    }

    private boolean canJumpDFS(int nums[], int index, Set<Integer> set)
    {
        if(nums.length == 1 || index == nums.length-1)
            return true;

        for(int i =1; i <= nums[index]; i++) {
            int newIndex = index + i;

            if(!set.contains(newIndex)) {
                set.add(newIndex);
                boolean canJump = canJumpDFS(nums, newIndex, set);
                if(canJump) return true;
            }
        }

        return false;
    }

    private boolean canJumpBFS(int nums[])
    {
        if(nums.length == 1)
            return true;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int target = nums.length - 1;

        queue.add(0);
        set.add(0);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                int index = queue.poll(); // this give the current index which be proceed

                for(int j  = 1; j <= nums[index]; j++)
                {
                    int newIndex = index + j;
                    if(newIndex == target)
                        return true;

                    if(!set.contains(newIndex)) {
                        set.add(newIndex);
                        queue.add(newIndex);
                    }
                }
            }
        }

        return false;
    }
}
