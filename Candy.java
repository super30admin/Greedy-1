
//TC: O(n)
//Sc: O(n)
/*
class Solution {
  public int candy(int[] ratings) {
      int res=0;
      int n=ratings.length;
      int[] distribution=new int[n];
      Arrays.fill(distribution,1);
      for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]){
              distribution[i]=distribution[i-1]+1;
          }
      }
      res=distribution[n-1];
      for(int i=n-2;i>=0;i--){
          if(ratings[i]>ratings[i+1]){
              distribution[i]=Math.max(distribution[i],distribution[i+1]+1);
          }
          res=res+distribution[i];
      }
      return res;
  }
}
*/
//TC: O(n)
//SC: O(1)
class Candy {
  public int candy(int[] ratings) {
      int res=1;
      int n=ratings.length;
      int oldslope=0;
      int newslope=0;
      int up=0;
      int down=0;
      for(int i=1;i<n;i++){
          if(ratings[i]>ratings[i-1]){
              newslope=1;
          }else if(ratings[i]<ratings[i-1]){
              newslope=-1;
          }else{
              newslope=0;
          }

          //if it is a trough
          if((newslope>=0 && oldslope<0) || (oldslope>0 && newslope==0)){
              res=res+total(up)+total(down)+Math.max(up,down);
              up=0;
              down=0;
          }
          if(newslope>0){
              up++;
          }else if(newslope<0){
              down++;
          }else{
              res++;
          }
          oldslope=newslope;
      }
      res=res+total(up)+total(down)+Math.max(up,down);
      return res;
  }

  private int total(int count){
      return (count*(count+1))/2;
  }
}