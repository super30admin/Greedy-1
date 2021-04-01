// Time complexity - O(n)
// Space complexity - O(n) - an additional array of length n
// Works on leetcode

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        
        // Check the left side
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i - 1] + 1; 
            }
        }
        
        // Check the right side
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i+1] + 1, candy[i]);
            }
        }
        
        // Calculate sum
        int sum = 0;
        for(int i=0;i<ratings.length;i++){
            sum = sum + candy[i];
        }
        return sum;
    }
}
