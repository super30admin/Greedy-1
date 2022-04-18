/*
Time Complexity: O(N), N is the number of elements in the given array
Space Complexity: O(1), constant space
Run on leetcode: yes
Any difficulties: no

Approach:
1. Our aim is to reach at the last position if we can, to reach at the last position I would be using index and number present
on that index,
2. Now the last position is gonna be the length of the array-1 as the index starts from 0, now to reach there, the loop should
run max of i+nums[i] times, and if the reach is greater than or equal to the last index that means we have reached to the
end and can return true otherwise return false
 */
public class JumpGame {
    public static boolean jumpGame(int[] nums){
        int lastPosition = nums.length-1;
        if(nums.length == 0 || nums == null){
            return true; // already on the begin/end position
        }

        int maxReach = 0; // initially it would be 0 and it would the jump index one can go to

        for(int i = 0; i<=maxReach; i++){
            maxReach = Math.max(maxReach, nums[i]+i);
            if(maxReach>= lastPosition){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int [] nums = {2,3,1,1,4};

        System.out.println("Can reach end: "+ jumpGame(nums));
    }
}
