class Candy {
    //time: O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int candy(int[] ratings) {
        //if no ratings
        if(ratings==null || ratings.length==0) return 0;
        //array to store number of candies for each student
        int[] candies = new int[ratings.length];
        //initializing number of candies to 1 for each student
        Arrays.fill(candies, 1);
        
        //left pass
        //looping through ratings from the start
        for(int i=1; i<ratings.length; i++){
            //rating of current student greater then student on left
            if(ratings[i]>ratings[i-1]){
                //increase no. of candies for current student one greater than previous student
                candies[i] = candies[i-1]+1;
            }
        }
        //initialize variable to store sum of all candies
        int sum=candies[candies.length-1];
        
        //right pass
        //looping through ratings from the end
        for(int i=ratings.length-2; i>=0; i--){
            //rating of current student greater then student on right
            if(ratings[i]>ratings[i+1]){
                //if student on right has more or equal no. of candies than current student
                //increase no. of candies for current student one more than student on left
                candies[i] = Math.max(candies[i], candies[i+1]+1);    
            }
            //add no. of candies for current student to sum
            sum += candies[i];
        }
        
        return sum;
    }
}