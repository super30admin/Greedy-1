// time - O(N)
// space - O(1)


class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        int jumps = 1;
        int curr = nums[0]; int next = nums[0]; // initialize curr and next value

        for(int i = 1; i < nums.length; i++) {

            next = Math.max(next,nums[i] + i); // find the max between previous max and addition of current eelement with index

            if( i < nums.length - 1 && i >= curr) { // if it reaches thee seegment theen increment jump and initialize curr element to next
                jumps++;
                curr = next;
            }

        }

        return jumps;

    }
}