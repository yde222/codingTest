class Solution {
    boolean[] visited;
    int [][] computers;

    public int solution(int n, int[][] computers) {
      this.visited = new boolean[n];    // 전역변수 초기화
        this.computers = computers;       // 전역변수 초기화
        int count = 0;


       for(int i= 0; i<n; i++){
           if(!visited[i]){
               count++;
               dfs(i);
           }
       }
       return count;
    }

    void dfs(int computer){
        visited[computer] = true;

        for(int i=0;i<computers.length;i++){
            if(computers[computer][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}