import java.util.Arrays;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class Candy {	
	/**Approach: Greedy**/
	public int candy(int[] ratings) {
        int n= ratings.length;        
        int[] candies= new int[n];
        Arrays.fill(candies, 1);
        //left pass
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = 1 + candies[i-1];
            }
        }
        //right pass
        int sum=candies[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i]= Math.max(candies[i], 1+candies[i+1]);                
            }
            sum+=candies[i];
        }
        return sum;
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		Candy ob  = new Candy();		
		int[] ratings = {1,0,2};
		System.out.println("Minimum number of candies to distribute: "+ob.candy(ratings));
	}
}
