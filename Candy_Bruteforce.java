//Problem 138: Candy
//TC:O(n^2)
//SC:O(n), for creating candies array

/*
 Steps: Bruteforce: Initailise the candy array with 1. Then keep incrementing the candies if ratings at current index is greater than its previous and next element as welll as as its candie values is also smaller or equal then increment the candies by 1. Repeat this process until, there is no change in the candies.

 Eg: [5,3,2,1,0]-> if ratings are given in descending order then, finding candies will take 4 steps. Therefore TC:O(n^2) 

*/

//Bruteforce
import java.util.*;
class SolutionBruteforce138 {
    public int candy(int[] ratings) {
        
        if(ratings==null || ratings.length==0) return 0;
        
        if(ratings.length==1) return 1;
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        int res = 0;
        boolean hasChange=true;
        while(hasChange){
            hasChange = false;
            for(int i=0;i<ratings.length;i++){
                //for first index
                if(i==0){
                    if(ratings[i]>ratings[i+1]){
                        if(candies[i]<=candies[i+1]){
                            candies[i] = candies[i+1]+1;
                            hasChange = true;
                        }
                    }
                }else if(i==ratings.length-1){//for last index
                
                       if(ratings[i]>ratings[i-1]){
                         if(candies[i]<=candies[i-1]){
                            candies[i] = candies[i-1]+1;
                            hasChange = true;
                          }
                       }
                    
                }else{
                    if(ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1]){
                        if(candies[i]<=candies[i-1] || candies[i]<=candies[i+1]){
                            candies[i] = Math.max(candies[i-1],candies[i+1])+1;
                            hasChange = true;
                        }
                    }else if(ratings[i]>ratings[i-1]){
                        if(candies[i]<=candies[i-1]){
                            candies[i] = candies[i-1]+1;
                            hasChange = true;
                        }
                    }else if(ratings[i]>ratings[i+1]){
                        if(candies[i]<=candies[i+1]){
                            candies[i] = candies[i+1]+1;
                            hasChange = true;
                        }
                    }
                }
                
            }
            
        }
       // System.out.println(Arrays.toString(candies));
        for(int elem:candies){
            res += elem;
        }
        
        return res;
    }
}
