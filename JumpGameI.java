
//BFS...gives TLE
/*
class Solution {
  public boolean canJump(int[] nums) {
      int n=nums.length;
      if(n==1){
          return true;
      }
      Queue<Integer> q=new LinkedList<>();
      q.add(0);
      while(!q.isEmpty()){
          int curr=q.poll();
          int jumps=nums[curr];
          for(int i=1;i<=jumps;i++){
              if(curr+i==n-1){
                  return true;
              }
              q.add(curr+i);
          }
      }
      return false;
  }
}
*/

//TC: O(n^2)
//SC: O(n)
//BFS with visited array does not give TLE
/*
class Solution {
  public boolean canJump(int[] nums) {
      int n=nums.length;
      if(n==1){
          return true;
      }
      boolean[] visited=new boolean[n];
      Queue<Integer> q=new LinkedList<>();
      q.add(0);
      visited[0]=true;
      while(!q.isEmpty()){
          int curr=q.poll();
          int jumps=nums[curr];
          for(int i=1;i<=jumps;i++){
              int newidx=curr+i;
              if(newidx==n-1){
                  return true;
              }
              if(!visited[newidx]){
                  q.add(newidx);
                  visited[newidx]=true;
              }
              
          }
      }
      return false;
  }
}
*/
//DFS
/*
class Solution {
  public boolean canJump(int[] nums) {
      int n=nums.length;
      if(n==1){
          return true;
      }
      boolean[] visi=new boolean[n];
      return dfs(nums,0,visi);
  }
  private boolean dfs(int[] nums, int idx,boolean[] visi){
      if(idx==nums.length-1){
          return true;
      }
      if(visi[idx]){
          return false;
      }
      int jumps=nums[idx];
      boolean val=false;
      for(int i=1;i<=jumps;i++){

          val=dfs(nums,idx+i,visi);
          if(val){
              return true;
          }
      }
      visi[idx]=true;
      return val;
  }
}
*/

//GREEDY....from back
/*
//TC: O(n)
class Solution {
  public boolean canJump(int[] nums) {
      int n=nums.length;
      int target=n-1;
      for(int i=n-2;i>=0;i--){
          if(nums[i]+i>=target){
              target=i;
          }
      }
      return target ==0;
  }
}
*/

//GREEDY....from front
//TC: O(n)
//SC: O(1)
class JumpGameI {
  public boolean canJump(int[] nums) {
      int n=nums.length;
      if(n<2){
          return true;
      }
      int currint=nums[0];
      int nextint=nums[0];
      for(int i=1;i<n;i++){
          if(currint>=n-1){
              return true;
          }
          nextint=Math.max(nextint,i+nums[i]);
          if(i==currint){
              //this means i cannot go to next window, eg. when we have 0
              if(currint==nextint){
                  return false;
              }
              currint=nextint;
          }
      }
      return false;
  }
}
