//TC - O(n)
//SC - O(n)

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] res = new int[ratings.length];
        
        for(int i = 0; i < res.length; ++i)
            res[i] = 1;
        
        int i= 1;
        
        while(i < ratings.length)
        {
            if(ratings[i] > ratings[i-1])
            {
                res[i] = Math.max(res[i], res[i-1]+1);
            }
            ++i;
        }
        
        i = ratings.length - 2;
        
        while(i >= 0)
        {
            if(ratings[i] > ratings[i+1])
            {
                res[i] = Math.max(res[i], res[i+1]+1);
            }
            --i;
        }
        
        int sum = 0;
        
        for(i = 0; i < res.length; ++i)
            sum += res[i];
        
        return sum;
    }
}
