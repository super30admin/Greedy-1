// 8/27 class
//time: O(3n) ~ O(n)
//space: O(n)
/*
class Solution {
public:
    int candy(vector<int> &ratings) {
        int size=ratings.size();
        if(size<=1)
            return size;
        vector<int> num(size,1);
        for (int i = 1; i < size; i++)
        {
            if(ratings[i]>ratings[i-1])
                num[i]=num[i-1]+1;
        }
        for (int i= size-1; i>0 ; i--)
        {
            if(ratings[i-1]>ratings[i])
                num[i-1]=max(num[i]+1,num[i-1]);
        }
        int result=0;
        for (int i = 0; i < size; i++)
        {
            result+=num[i];
            // cout<<num[i]<<" ";
        }
        return result;
    }
};
*/

//time: true O(n)
//space: O(1)
class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        int candy = n, i=1;
        while(i<n){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }
            
            //For increasing slope
            int peak = 0;
            while(ratings[i] > ratings [i-1]){
                peak++;
                candy += peak;
                i++;
                if(i == n) return candy;
            }
            
            //For decreasing slope
            int valley = 0;
            while(i<n && ratings[i] < ratings[i-1]){
                valley++;
                candy += valley;
                i++;
            }
            candy -= min(peak, valley); //Keep only the higher peak
        }
        return candy;
    }
};

//paresh soln - true O(n) time, O(1) space
/*
class Solution {
public:
    int candy(vector<int>& ratings) {
        int up=0;
        int down=0; 
        int prev_peak=0; 
        int n=ratings.size(); 
        int total=n;

        for(int i=0;i<n-1; i++){
            if(ratings[i] < ratings[i+1]){
                down = 0;
                up += 1;
                prev_peak = up;
                total += up;
            }
            else if(ratings[i] == ratings[i+1]){
                up = 0;
                down = 0;
                prev_peak = 0;
            }
            else{
                up = 0;
                down += 1;
                total += (down - int(prev_peak>=down));
            }
        }
        return total;
    }
};
*/