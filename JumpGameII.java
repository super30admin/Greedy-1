/*
Time Complexity: O(N)
SPace Complexity: O(1), constant space
Run on leetcode: yes
Any difficulties: no

Approach:
1. The question says that we can always reach to the last index, we just need to calculate minimum number of jumps to reach
there
2. To solve this, I am gonna maintain three variables one is current index, destination index
(current index+number at current index), and jump count;
3. Now if it seems that my current position is equals to the iterating index than I am gonna updated my current index
then I am gonna update my destination index with the max of the value and increment the possible jump count
4. At the end I am gonna return jump count
 */
public class JumpGameII {
    public static int jumpGameII(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int currPos = 0;
        int destPos = 0;
        int jump = 0;
        // assuming that we always reach to the end I am gonna iterate till nums.length-1
        for(int i = 0; i<nums.length-1; i++){
            destPos = Math.max(destPos, i+nums[i]);

            if(currPos == i){
                currPos = destPos;
                jump++;
            }
        }
        return jump;
    }

    public static void main(String[] args){
        System.out.println("Number of jumps required: "+ jumpGameII(new int[]{2,3,1,1,4}));
    }
}
