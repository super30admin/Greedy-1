/*
Approach 1: Recursion - Backtracking
TC: O(2^n)
SC: O(N)

1. Try every reachable position from given index and check if it is possible to reach last index.
2. Do it recursively.

Approach 2: Greedy

TC: O(N)
SC: O(1)

1. We determine if its possible to reach last index from given index. The index will be a good index. 
2. If it is possible to jump to a good index from current index, current index also becomes a good index.

*/

public class JumpGameI{
    public boolean canJumpGreedy(int[] arr){
        int pos = arr.length - 1;

        for(int i = arr.length - 2; i >= 0; i--){
            if(i + arr[i] >= pos){
                pos = i;
            }
        }

        return pos == 0;
    }

    public boolean canJumpRecursion(int[] arr){
        return helper(0, arr);
    }

    private boolean helper(int pos, int[] nums){
        if(pos == nums.length - 1){
            return true;
        }

        int farJump = Math.min(pos + nums[pos], nums.length - 1);
        for(int nextPos = pos + 1; nextPos <= farJump; nextPos++){
            if(helper(nextPos, nums)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2,3,1,1,4};
        JumpGameI JG = new JumpGameI();

        System.out.println(JG.canJumpGreedy(arr));
        System.out.println(JG.canJumpRecursion(arr));
    }
}