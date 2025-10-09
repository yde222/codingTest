import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            arr[i][0] = jobs[i][0];
            arr[i][1] = jobs[i][1];
            arr[i][2] = i;
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2]- b[2];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            if(a[1] != b[1]) return a[1]-b[1];
            if(a[0]!= b[0]) return a[0]- b[0];
            return a[2]- b[2];
        });
        
        long time =0;
        long total =0;
        int i= 0;
        
        while (i< n || !pq.isEmpty()){
            while(i<n && arr[i][0] <=time){
                pq.offer(arr[i++]);
            }
            if(pq.isEmpty()){
                time = Math.max(time,arr[i][0]);
                continue;
            }
            
            int[] job = pq.poll();
            time += job[1];
            total += (time - job[0]);
            
        }
        return (int)(total / n);
            
    }
}