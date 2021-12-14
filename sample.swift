// Time Complexity : 0(N)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

        if ratings.count == 1 {
            return 1
        }
        var candyarr = Array(repeating: 1, count: ratings.count)
        var candyarr2 = Array(repeating: 1, count: ratings.count)
        var count = 0
        for i in (0...ratings.count-2).reversed() {
            if ratings[i] > ratings[i+1]  {
                candyarr[i] = candyarr[i+1] + 1
            }
        }
        for i in 0..<candyarr2.count {
            if i != 0 && ratings[i] > ratings[i-1]  {
                candyarr2[i] = max(candyarr2[i-1] + 1,candyarr[i])
            } else {
                candyarr2[i] = candyarr[i]
            }
            count += candyarr2[i]
        }
        return count
    }
