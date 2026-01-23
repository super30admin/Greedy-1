
class JumpGame {
    // Set<Integer> visitedSet = new HashSet<>();
    public boolean canJump(int[] nums) {
        // a. bfs - add indexes to queue
        // have a visited set to avoid repeated visitings
        if(nums.length == 1) return true;
        // Queue<Integer> queue = new LinkedList<>();
        // visitedSet = new HashSet<>();

        // queue.add(0);
        // visitedSet.add(0);
        // while(!queue.isEmpty())
        // {
        //     int currIndex = queue.poll();
            
        //     for(int i = 1; i <= nums[currIndex]; i++)
        //     {
        //         int newIndex = currIndex + i;
        //         if(newIndex == nums.length - 1) return true;
        //         if(!visitedSet.contains(newIndex))
        //         {
        //             queue.add(newIndex);
        //             visitedSet.add(newIndex);
        //         }
        //     }
        // }

        // return false;

        // b. dfs - recursively call and mark visied index in set
        // return dfs(nums, 0);

        // c. traverse from end and check if can reach target n-1 by checking with n-2
        // decrement target by 1 and i by 1 if reaching taget
        // else just decrement i by 1
        // if target can become 0 then return true - else false
        int target = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] + i >= target)
            {
                target = i;
            }
        }

        return 0 == target;
    }

    // private boolean dfs(int[] nums, int index)
    // {
    //     // base
    //     if(index == nums.length - 1) return true;
    //     if(visitedSet.contains(index)) return false;

    //     //logic
    //     for(int i = 1; i <= nums[index]; i++)
    //     {
    //         int newIndex = index + i;
    //         if(dfs(nums, newIndex)) return true;
    //     }

    //     visitedSet.add(index);
    //     return false;
    // }
}