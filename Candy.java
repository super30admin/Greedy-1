/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class Candy
{
    public int candy(int[] ratings) {

        int length = ratings.length;

        int output[] = new int[length];
        Arrays.fill(output, 1);

        int result = 0;

        for(int i = 1; i < length; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                output[i] = output[i-1] + 1;
            }
        }

        for(int i = length -2; i >=0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                output[i] = Math.max(output[i], output[i+1] +1);
            }
        }

        for(int i: output)
            result = result + i;


        return result;

    }
}
