import java.util.*;

class Solution {
    
     static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] blocked = new boolean[n + 1][m + 1];
        for(int [] p:puddles){
            blocked[p[1]][p[0]]= true;
        }
        
        long[] dp = new long[m+1];
        dp[1] = blocked[1][1]? 0:1;
        
        for(int y = 1; y<=n; y++){
            for(int x=1; x<=m; x++){
                if(blocked[y][x]){
                    dp[x]=0;
                }else if(!(y==1 && x==1)) {
                    dp[x] = (dp[x] + dp[x-1]) % MOD;
                }
            }
        }
        return (int)dp[m];
    }
    
}
