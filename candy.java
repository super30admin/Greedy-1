//Timecomplexity:- O(N).
//space complexity:- O(N).
//Did it run on leetcode:- yes.
//Approach with code:- first passing left to right and changing candies values if current value is greater than previous value
//and after we will travel from back and update max in both.
//finally sum of updated array is taken.




class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        int sum=candies[candies.length-1];
       
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
                
            }
            sum=sum+candies[i];
        }
       return sum; 
    }
}