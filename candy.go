// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create candy array where each child gets 1 candy
do a left pass starting at i=1 where if current rating is more than previous then current person gets 1more candy than previous
do a right pass starting at i=len-2 and decrementing where if current rating is more than next then current person gets 1more candy than next
return sum of candy array
*/
package main

import "fmt"

func candy(ratings []int) int {
	if len(ratings) == 0 {
		return 0
	}
	c := make([]int, len(ratings))
	for i := 0; i < len(ratings); i++ {
		c[i] = 1
	}
	//left pass
	for i := 1; i < len(ratings); i++ {
		if ratings[i] > ratings[i-1] {
			c[i] = c[i-1] + 1
		}
	}
	//right pass
	for i := len(ratings) - 2; i >= 0; i-- {
		if ratings[i+1] < ratings[i] {
			c[i] = max(c[i], c[i+1]+1)
		}
	}
	sum := 0
	for i := 0; i < len(ratings); i++ {
		sum += c[i]
	}
	return sum
}

func max1(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func MainCandy() {
	fmt.Println(candy([]int{1, 0, 2})) //expected 5
}
