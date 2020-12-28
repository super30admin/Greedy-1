//time complexity:O(n)
//space complexity:O(n)

class Solution {
    public int candy(int[] ratings) {
        int output=0;
        int result[]=new int[ratings.length];
        Arrays.fill(result,1);
        for(int i=1;i<ratings.length;i++)
        {
                if(ratings[i]>ratings[i-1])
                {
                    result[i]=result[i-1]+1;
                }
            }
        for(int i=ratings.length-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                result[i]=Math.max(result[i],result[i+1]+1);
            }
        }
        for(int i=0;i<result.length;i++)
        {
            output+=result[i];
        }
           return output;
        }
     
}
