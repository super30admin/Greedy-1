// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class Candy {
	 public int candy(int[] ratings) {
	        if(ratings.length==1) return 1;
	        int result=0;
	        int[] candies=new int[ratings.length];
	        Arrays.fill(candies,1);
	        for(int i=0;i<ratings.length;i++){
	            if(i==0 && ratings[i+1]<ratings[i]){
	                candies[i]=candies[i+1]+1;
	            }else if(i==ratings.length-1 && ratings[i-1]<ratings[i]){
	                 candies[i]=candies[i-1]+1;
	            }else if(i!=0 && i!=ratings.length-1){
	                if(ratings[i+1]<ratings[i] && ratings[i-1]<ratings[i]){
	                     candies[i]=Math.max(candies[i-1],candies[i+1])+1;
	                }else if(ratings[i+1]<ratings[i]){
	                  candies[i]=candies[i+1]+1;
	                }else if(ratings[i-1]<ratings[i]){
	                    candies[i]=candies[i-1]+1; 
	                }
	            }
	        }
	        
	         for(int i=ratings.length-1;i>=0;i--){
	            if(i==0 && ratings[i+1]<ratings[i]){
	                candies[i]=Math.max(candies[i],candies[i+1]+1);
	            }else if(i==ratings.length-1 && ratings[i-1]<ratings[i]){
	                 candies[i]=Math.max(candies[i],candies[i-1]+1);
	            }else if(i!=0 && i!=ratings.length-1){
	                if(ratings[i+1]<ratings[i]){
	                  candies[i]=Math.max(candies[i],candies[i+1]+1);
	                }else if(ratings[i-1]<ratings[i]){
	                    candies[i]=Math.max(candies[i],candies[i-1]+1); 
	                }
	            }
	        }
	        
	        for(int i:candies){
	            result+=i;
	        }
	        
	        return result;
	    }
}
