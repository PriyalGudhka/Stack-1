// Time Complexity : O(n) to iterate over the entire array
// Space Complexity : O(n) as we are using an explicit stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using monotonically increasing stack approach. We start iterating over the temperatures array and in the stack we will store the index for which the warmer temperature isn't found.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures == null || temperatures.length == 0){
            return new int[]{};
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){

            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int popped = s.pop();
                result[popped] = i - popped;
            }
            s.push(i);
        }

        return result;
    }
}