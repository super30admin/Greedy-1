//problem1
class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        int target=n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=target){
                target=i;
            }
        }
        return target==0;
    }
}
//problem2
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int temp1=nums[0];
        int temp2=nums[0];
        int jmp=1;
        for(int i=1;i<n;i++){
            temp1=Math.max(temp1,i+nums[i]);
            if(i!=n-1 && i==temp2){
                jmp++;
                temp2=temp1;
            }
        }
        return jmp;
    }
}
//problem3
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for(int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int total = 0;
        for(int i = 0; i < n; i++) {
            total = total + candies[i];
        }
        return total;
    }
}
