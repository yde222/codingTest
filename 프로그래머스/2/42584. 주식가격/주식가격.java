import java.util.*;

class Solution {
     public int[] solution(int[] prices) {

        int n = prices.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[stack.peek()]> prices[i]){
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            result[idx] = n-1-idx;
        }

        return result;

    }
}