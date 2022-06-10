//TC : O(N)
//SC : O(N)
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length==0) return 0;

        int n = ratings.length;
        int[] result = new int[n];
        int candy=0;
        //Step 1 : First Pass
        result[0] = 1;
        for(int i = 1;i<n;i++)
        {
            if(ratings[i] > ratings[i-1])
                result[i] = result[i-1]+1;
            else
                result[i] = 1;
        }

        //step 2 : second pass from the end and calculate the fical candy count
        candy = result[n-1];
        for(int i = n-2;i>=0;i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                if(result[i+1] >= result[i])
                    result[i] = result[i+1]+1;
            }
            candy+=result[i];
        }

        return candy;
    }
}