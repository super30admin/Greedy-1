class Solution {

    //Time Complexit: O(n)
    //Space Complexity: O(n)

    public int candy(int[] ratings) {
        
        if(ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;

        int[] result = new int[n];                  //creating the result array, in which we are storing the candy that we have to give to each kid
        
        Arrays.fill(result, 1);                     //each child get one candy at least, so for that we are filling the result array by 1
        
        //forward pass, in that, we are just considering the left neightbour, and give candy accordingly
        for(int i = 1; i<n; i++){

            if(ratings[i-1] < ratings[i]){
                result[i] = result[i-1] + 1;
            }
        }

        //backward pass, in that, we are just considering the right neightbour, and give candy accordingly
        int total = result[n-1];                //creating the variable which stores the total number of candy that we have to distribute

        for(int i = n-2; i>=0; i--){            //itrating through the end of the array

            if(ratings[i] > ratings[i+1]){          //check if the right neighbour has the higher rating
                result[i] = Math.max(result[i], result[i+1] + 1);       //if so, then, we take maximum between the current value and right neightbour value plus 1, here, we are taking maximum because we can't ignore the left neighbour value, result[i] represent the left neighbour value
            }
            total += result[i];                 //adding to the total
        }
        return total;
    }
}
