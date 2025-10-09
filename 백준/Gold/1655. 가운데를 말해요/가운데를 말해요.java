import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for(int i =0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            
            if(left.size()== right.size()){
                left.offer(x);
            }else{
                right.offer(x);
            }
     
            if(!right.isEmpty()&& left.peek() >right.peek()) {
                int a = left.poll();
                int b = right.poll();
                left.offer(b);
                right.offer(a);
            }
            sb.append(left.peek()).append('\n');
        }
        System.out.print(sb);
    }
  }