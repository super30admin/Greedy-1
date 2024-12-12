Time Complexity (TC): O(n), where n is the length of the ratings array, as we traverse the array once while handling up and down slopes.
Space Complexity (SC): O(1), as the solution uses only a constant amount of extra space.

class Solution {
    public int candy(int[] ratings) {
        int index=1;
        int sum=1;
        int n=ratings.length;
        while(index<n){
            //flat
            if( ratings[index]==ratings[index-1]){
                sum+=1;
                index++;
                continue;
            }

            //up slop
            int peek=1;
            while(index<n && ratings[index]>ratings[index-1]){
                peek++;
                sum+=peek;
                index++;
            }
            int down=1;
             while(index<n && ratings[index]<ratings[index-1]){
                sum+=down;

                down++;
                 index++;
            }
            if(down>peek){
                sum+=down-peek;
            }
        }
        return sum;
    }
}