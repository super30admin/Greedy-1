/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/

import java.util.ArrayList;
import java.util.List;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        List<Integer> path = new ArrayList<>();

        int currInt = 0;

        int nextInt = 0;

        int n = nums.length;

        int jumps = 0;

        for (int index = 0; index < n; index++) {
            if (nextInt < index + nums[index]) {
                nextInt = index + nums[index];
                path.add(index);
            }

            if (nextInt >= n - 1) {
                path.add(n - 1);
                System.out.println(path);
                return jumps + 1;
            }

            if (currInt == index) {
                currInt = nextInt;
                jumps++;
            }
        }

        return jumps - 1;
    }
}
