import java.util.Arrays;

/*
Time complexity: O(N), have to iterate over the ratings array inorder to calculate number of candies
Space Complexity: O(N), using candies array
Run on leetcode: yes
Any difficulties: no

Approach:
1. To Solve this problem, I will be using left and right greedy pass, I am gonna compare iterate from the left to the right
and will keep increasing candy count for the neighbor child if it has the greater rating than it's left neighbor, that's
how I would be able to allocate the maximum candies(compare to the it's neighbor) to the right child
2. Now I am gonna traverse the ratings array to assign the required candies to the left most child too, based on the ratings
comparison I am gonna do this job, and would add candies number to my sum variable
 */
public class Candy {
    public static int totalNumberOfCandies(int[] ratings){
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int[] candies = new int[ratings.length];

        Arrays.fill(candies,1);

        for(int i = 1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sumOfCandies = candies[candies.length-1];

        for(int i = ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }

            sumOfCandies+= candies[i];
        }
        return sumOfCandies;
    }
    public static void main(String[] args){
        int[] nums = {1,0,2};
        int[] ratings = {1,2,2};
        System.out.println("Total number of candies required: "+totalNumberOfCandies(nums));
        System.out.println("Total number of candies required: "+totalNumberOfCandies(ratings));
    }
}
