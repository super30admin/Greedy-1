//Time: O(n)
//Space: O(n)

/*

`          `
 `  `     ` `
  `` `   `   `
  a,b ` `     `
       `       d
       c

Find all local minima. Assign 1 candy to the local minima, 
then incrementally go upwards in left direction and right direction (until the upward spike ends)
assigning 1 more candy to the child than its previous
*/


class Solution {
public:
    int candy(vector<int>& v) {
        int n = v.size();

        //candies[i] = candies that child i gets
        vector<int> candies(n, -1), minima;

        //find local minimas
        for(int i=0;i<n;i++){
            if((i==0 || v[i-1] >= v[i]) && (i==n-1 || v[i+1] >= v[i]))  minima.push_back(i);
        }

        for(int k=0;k<minima.size();k++){
            int m = minima[k];

            //incrementally go upwards towards left
            int c = 1;
            for(int i=m; i>=0;i--){
                candies[i] = max(candies[i], c); //if a child has been assigned candies, see if we need to assign an amount greater than the previously assigned
                c++;
                if(i == 0 || v[i-1] <= v[i])  break;
            }

            //incrementally go upwards towards right
            c = 1;
            for(int i=m; i<n;i++){
                candies[i] = max(candies[i], c);
                c++;
                if(i == n-1 || v[i+1] <= v[i])  break;
            }
        }

        //sum up candies
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += candies[i]; 
        }

        return ans;
    }
};
