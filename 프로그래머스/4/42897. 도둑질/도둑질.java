import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        if(n == 1) return money[0];
        if(n == 2) return Math.max(money[0],money[1]);

        int case1 = robRange(money, 0, n-2);
        int case2 = robRange(money, 1, n-1);

        return Math.max(case1, case2);
    }

    private  int robRange(int[] money, int start, int end){
        int prev1=0, prev2=0;
        for(int i= start; i<=end; i++){
            int curr = Math.max(prev1, prev2+money[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}