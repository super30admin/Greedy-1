
//Time-o(n)
//space-o(n)
//Found out a o(1) solution online, but too tricky to understand, so sticking to this
class Solution {
    public int candy(int[] ratings) {
        
    int [] candies=new int[ratings.length];
    Arrays.fill(candies,1);
     for(int i=1;i<ratings.length;i++)
     {
         if(ratings[i]>ratings[i-1])
         {
             candies[i]=candies[i-1]+1;
         }
     }
    for(int i=ratings.length-2;i>=0;i--)
    {
        if(ratings[i]>ratings[i+1])
        {
            candies[i]=Math.max(candies[i],candies[i+1]+1);
            
        }
    }
        
    int output=0;
    for(int i=0;i<candies.length;i++)
    {
        output+=candies[i];
    }
        
       return output; 
    }
}
