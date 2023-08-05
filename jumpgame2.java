// tc : O(n*n)
  //  in worst case each jump could have n-2 n-3 n-4 ... 3 2 1 1 0.  in this case thsi would have taken n(n+1)/2 - n = roughly n*n
// sc : O(n)
  

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minSteps = new int[n];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        minSteps[0] = 0 ;
        for(int i = 0 ; i<n ; i++){
            for(int j = i ; j< Math.min(nums[i]+i+1, n); j++){
                minSteps[j] = Math.min(minSteps[j], minSteps[i] + 1);
            }
        }
        return minSteps[n-1];
    }
}
