import java.util.Arrays;
import java.util.Scanner;

public class CandyGreedy {

        // Greedy - Local optima to global optima - Time O(n) and Space O(n)

        public int candy(int[] ratings) {

            // null case
            if(ratings == null)       return 0;

            // create candies array with default 1 values satisfying the first condition of at least one candy to each child
            int n = ratings.length;
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            // forward pass
            for(int i = 1; i < n; i++) {

                // if rating is higher than left neighbour
                if(ratings[i] > ratings[i-1]) {

                    // give one more candy than left neighbour
                    candies[i] = 1 + candies[i-1];
                }
            }

            // total count starts from right end
            int minNumCandies = candies[n-1];

            // backward pass
            for(int i = n-2; i >= 0; i--) {

                // if rating is higher than right neighbour
                if(ratings[i] > ratings[i+1]) {

                    // give one more candy than right neighbour and check with existing value
                    candies[i] = Math.max(candies[i], 1 + candies[i+1]);
                }

                // add final values of candies after assignment in backward pass to total count
                minNumCandies += candies[i];
            }

            // output
            return minNumCandies;
        }

        public static void main(String[] args) {

            CandyGreedy obj = new CandyGreedy();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of children: ");
            int n = scanner.nextInt();

            int[] ratings = new int[n];
            System.out.println("ratings of children: ");
            for(int i = 0; i < n; i++) {
                ratings[i] = scanner.nextInt();
            }

            int minTotal = obj.candy(ratings);
            System.out.println("minimum number of candies to be distributed to children: " + minTotal);
        }

}

/*
TIME COMPLEXITY = O(n)

forward and backward iterations over ratings array - O(2n) = O(n)
SPACE COMPLEXITY = O(n)

candies array - O(n) space
*/

