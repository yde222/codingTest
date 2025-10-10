import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    private void dfs(int fatigue, int[][] d, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < d.length; i++) {
            int need = d[i][0];
            int cost = d[i][1];
            if (!visited[i] && fatigue >= need) {
                visited[i] = true;
                dfs(fatigue - cost, d, visited, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}