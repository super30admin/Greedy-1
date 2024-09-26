// TC: O(n)
// SC: O(n)

class Candy {
    public int candy(int[] ratings) {
        int curr = -1;
        int[] candy = new int[ratings.length];
        // Filling array with one since each of them will get atleast one candy
        Arrays.fill(candy, 1);
        // Check from the left side if the current rating is greater than previous then take the max of the curr candy count + 1 and just the previous
        for(int i=1; i<ratings.length; i++)
        {
            if(ratings[i] > ratings[i-1]){
                candy[i] = Math.max(candy[i-1] + 1, candy[i]);  
            }
        }
        // Now do the same by moving from right
        for(int i=ratings.length-2; i>=0; i--)
        {
            if(ratings[i+1] < ratings[i]){
                candy[i] = Math.max(candy[i+1]+ 1, candy[i]) ;  
            }
        }
        int max = 0;
        // Sum up the candies array and return
        for(Integer i : candy){
            max += i;
        }
        return max;        
    }
}