// Time Complexity : O(n) to iterate over the entire array
// Space Complexity : O(n) as we are using an explicit stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using monotonically increasing stack approach. We will iterate over nums[] twice as it is a cicular array. We will store the index for which we are unable to find the greater element and to keep in loop we will use i%n
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];

        Arrays.fill(result, -1);

        for(int i = 0; i < 2*n; i++){

            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                int popped = s.pop();
                result[popped] = nums[i%n];
            }

            //To avoid iterating over the same index
            if(!s.isEmpty() && (i%n == s.peek())){
                break;
            }

            //only push if it's the first time
            if(i < n){
                s.push(i);
            }
        }

        return result;
    }
}