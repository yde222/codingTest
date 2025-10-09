import java.util.*;

class Solution {
    static class Node{
        int to,w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] r: road){
            int a = r[0], b= r[1], c= r[2];
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        final int INF = 1000000000;
        int[] dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[1] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
         pq.offer(new int[]{0,1});

        while(!pq.isEmpty()){
          int[] cur = pq.poll();
          int t = cur[0],u=cur[1];
          if(t != dist[u]) continue;
          for(Node n: graph.get(u)){
              int v = n.to, nt = t+ n.w;
              if(nt < dist[v]){
                  dist[v] = nt;
                  pq.offer(new int[]{nt,v});
              }
          }
        }

        int answer = 0;
        for(int i= 1; i<=N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;


    }
}