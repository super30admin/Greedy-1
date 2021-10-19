using System;
using System.Collections.Generic;
using System.Text;

namespace BFSnDFS
{
    class JumpsIILC
    {
        //TC: O(n)
        //SC:O(1)
        public int Jump(int[] nums)
        {
            if (nums == null || nums.Length < 2) return 0;
            int n = nums.Length;
            int curr = nums[0];
            int farthest = nums[0];
            int jumps = 1;
            for (int i = 0; i < n; i++)
            {
                farthest = Math.Max(farthest, nums[i] + i);
                if (i < n - 1 && i == curr)
                {
                    curr = farthest;
                    jumps++;
                }
            }
            return jumps;
        }
    }
}
