import java.util.Arrays;

public class problem3 {


    // 2 pass solution
    //Time Complexity:O(2n)
    // Space Complexity: O(n)
    public int candy1(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        Arrays.fill(candies,1);

        for (int i=1;i<n;i++)
        {
            if (ratings[i]>ratings[i-1])
            {
                candies[i]=candies[i-1]+1;
            }

        }
        for (int i=n-2;i>=0;i--)
        {
            if (ratings[i]>ratings[i+1])
            {
                candies[i]= Math.max(candies[i],candies[i+1]+1);
            }
        }
        int total=0;
        for (int num:candies)
        {
            total+=num;
        }
        return total;
    }

    // slope solution
    //Time Complexity:O(n)
    // Space Complexity: O(1)
    public int candy2(int[] ratings) {
        int n=ratings.length;
        int up=0, down=0;
        int oldSlope=0, newSlope=0;
        int candies=0;
        //1 : increasing slope
        //-1 : descresing slope
        // 0, flat land

        for (int i=1;i<n;i++)
        {
            newSlope= (ratings[i]<ratings[i-1]) ? -1 : ((ratings[i]> ratings[i-1]) ? 1 : 0);

            if((oldSlope>0&&newSlope==0) ||(oldSlope<0 &&newSlope>=0)){
                candies+= count(up) + count(down) + Math.max(up,down);
                up=0;
                down=0;
            }
            if (newSlope==1){up++;}
            if (newSlope==-1){down++;}
            if (newSlope==0){candies++;}
            oldSlope=newSlope;

        }
        candies+= count(up) + count(down) + Math.max(up,down);
        return candies+1;
    }
    public int count(int num) {
        return num*(num+1)/2;
    }

}
