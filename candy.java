// TC: O(2n)
// SC: O(n)
class Solution {
    public int candy(int[] nums) {
        int n=nums.length;
        int candies[]= new int [n];
        
        Arrays.fill(candies,1);
        
        //left pass
        for(int i=1;i<n; i++){
            if(nums[i]> nums[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        //right pass
        int sum=candies[n - 1];
        for (int i=n-2; i>=0;i--){
            if(nums[i]> nums[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
            sum+=candies[i];
        }
        
        return sum;
    }
}
