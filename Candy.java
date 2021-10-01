class Solution {
    public int candy(int[] ratings) {
        //Base:
        if(ratings==null || ratings.length == 0 ){
            return 0;
        }
        
        //Logic:
        //Initialise the candies for all children by '1'
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        //Check from left to right if candies are in increasing as per rating
        for(int i=1; i<n; i++){
            //Since the rating of left is high , increase by 1
            if(ratings[i]> ratings[i-1]){
                //Since this is first traversal, just increment by 1
                candies[i] = candies[i-1]+1;
            }
            System.out.print(candies[i]+" ");
        }
        //Now check from right to left if candies are in distributed correct as per rating
        //So comparison is started from (n-2)th element
        int sum = candies[n-1];
        for(int j=n-2; j>=0; j--){
            if(ratings[j]> ratings[j+1]){
                //Mistake: when comparing from right end, compare after incrementing the right choco val
                candies[j] = Math.max(candies[j], candies[j+1]+1);
            }
            sum+=candies[j];
        }
        return sum;
    }
}
// [1,2,3,4,0,1,5,3,7]
