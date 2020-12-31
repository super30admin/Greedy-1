// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set currInt, nextInt to first element value
set jumps to 1
loop over nums starting at 1
nextInt is max between nextInt, nums[i]+i
if i<len(nums)-1 and i==currentint then select it and set currInt to nextInt and increment jumps
finally return jumps
*/
package main

import "fmt"

//var min int
func jump(nums []int) int {
	if len(nums) < 2 {
		return 0
	}
	//greedy
	currInt := nums[0]
	nextInt := nums[0]
	jumps := 1
	for i := 1; i < len(nums); i++ {
		nextInt = max(nextInt, nums[i]+i)
		if i < len(nums)-1 && i == currInt {
			currInt = nextInt
			jumps++
		}
	}
	return jumps
	/*min = 100000
	  dfs(nums, 0, 0)
	  return min*/
}

/*func dfs(nums []int, ind int, jumps int) {
    if ind >= len(nums) - 1 {
        min = fmin(min, jumps)
        return
    }
    for j := 1; j<= nums[ind];j++ {
        dfs(nums, ind + j, jumps+1)
    }
}*/

func fmin(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func fmax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func MainJumps() {
	fmt.Println(jump([]int{2, 3, 1, 1, 4})) //expected 2
}
