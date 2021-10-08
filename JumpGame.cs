using System;
using System.Collections.Generic;
using System.Text;

namespace BFSnDFS
{
    class JumpLC
    {
        //TC: O(n)
        //SC:O(1)
        public bool CanJumpOptimized(int[] nums)
        {
            if (nums == null || nums.Length < 2) return true;
            int n = nums.Length;
            int destination = n - 1;
            for (int i = n - 2; i >= 0; i--)
            {
                if (nums[i] + i >= destination)
                {
                    destination = i;
                }
            }
            return destination == 0;
        }

        //TC: O(n^n) exponential
        //SC:O(n)
        public bool CanJump(int[] nums)
        {
            if (nums == null || nums.Length < 2) return true;
            //BFS approach
            HashSet<int> set = new HashSet<int>();
            Queue<int> q = new Queue<int>();
            q.Enqueue(0);
            set.Add(0);
            while (q.Count != 0)
            {
                int curr = q.Dequeue();
                for (int i = 1; i <= nums[curr]; i++)
                {
                    int newIndex = curr + i;
                    if (!set.Contains(newIndex))
                    {
                        if (newIndex == nums.Length - 1) return true;
                        set.Add(newIndex);
                        q.Enqueue(newIndex);
                    }
                }
            }
            return false;
        }
        //TC: O(n^n) exponential
        //SC:O(n)
        HashSet<int> set;
        public bool CanJumpDFS(int[] nums)
        {
            if (nums == null || nums.Length < 2) return true;
            //DFS approach
            set = new HashSet<int>();
            return dfs(nums, 0);
        }
        private bool dfs(int[] nums, int idx)
        {
            //base
            if (idx == nums.Length - 1) return true;
            if (set.Contains(idx)) return false;
            //logic
            set.Add(idx);
            for (int i = 1; i <= nums[idx]; i++)
            {
                if (dfs(nums, idx + i))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
