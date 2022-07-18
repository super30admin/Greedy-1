using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class JumpGame
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        public bool CanJump_Greedy(int[] nums)
        {
            if (nums.Length == 0) return true;
            int n = nums.Length;
            int target = n - 1;
            for (int i = n - 2; i >= 0; i--)
            {
                if (i + nums[i] >= target)
                {
                    target = i;
                }
            }
            return target == 0;
        }

        public bool CanJump_BFS(int[] nums)
        {
            //BFS
            //null case
            if (nums.Length == 1) return true;
            Queue<int> q = new Queue<int>();
            HashSet<int> visited = new HashSet<int>();
            int n = nums.Length;
            q.Enqueue(0);
            visited.Add(0);
            while (q.Count != 0)
            {
                int currIndex = q.Dequeue();

                for (int j = 1; j <= nums[currIndex]; j++)
                {
                    int newIndex = currIndex + j;
                    if (newIndex >= n - 1) return true;
                    if (!visited.Contains(newIndex))
                    {
                        visited.Add(newIndex);
                        q.Enqueue(newIndex);
                    }
                }
            }
            return false;
        }



        HashSet<int> visited;
        public bool CanJump_DFS(int[] nums)
        {
            //DFS
            if (nums.Length == 1) return true;
            visited = new HashSet<int>();
            return dfs(nums, 0);
        }

        private bool dfs(int[] nums, int i)
        {
            //base
            if (i == nums.Length - 1) return true;
            visited.Add(i);
            //logic
            for (int j = 1; j <= nums[i]; j++)
            {
                int newIndex = j + i;
                if (!visited.Contains(newIndex) && dfs(nums, newIndex)) return true;
            }

            return false;
        }
    }
}
