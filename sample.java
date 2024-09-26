// Problem 1 - Jump I
// Time Complexity : O(n) where n = number of elements in array
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
// 1 - initialize destination
// 2 - loop from second last element
// 3 - if curr element + index is equals or greater to destination
// 4 - then change the destination to current index
// 5 - return destination equals 0
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        // 1
        int destination = nums.length - 1;
        //2
        for (int i=nums.length-2; i>=0; i-=1) {
            // 3
            if (nums[i] + i >= destination) {
                // 4
                destination = i;
            }
        }
        // 5
        return destination == 0;
    }
}

// Problem 2 - Jump II
// Time Complexity : O(n) where n = number of elements in array
// Space Complexity : O(1)

// Your code here along with comments explaining your approach
// 1 - initialize currInterval and nextInterval to first element
// 2 - initialize jumps to 1
// 3 - loop over array from second element
// 4 - if current elem + curr index is greater than nextInterval, change nextInterval
// 5 - if currInterval equals curr index and curr index not equals last index, then change currInterval to nextInterval and increment jumps
// 6 - if currInterval goes out of bound, then break from the loop
// 7 - return jumps
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 1
        int currInterval = nums[0];
        int nextInterval = nums[0];
        // 2
        int jumps = 1;
        // 3
        for(int i=1; i<nums.length; i++) {
            // 4
            if (nums[i] + i > nextInterval) {
                nextInterval = nums[i] + i;
            }
            // 5
            if(currInterval == i && i != nums.length - 1) {
                currInterval = nextInterval;
                jumps++;
            }
            // 6
            if(currInterval >= nums.length - 1) {
                break;
            }

        }
        // 7
        return jumps;
    }
}
