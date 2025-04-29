import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
            if (absCompare == 0) return Integer.compare(o1, o2);
            return absCompare;
        });

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<n;i++){
            int x = sc.nextInt();
            if(x==0){
                if(pq.isEmpty()) {
                    sb.append("0\n");
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            }else {
                pq.offer(x);
            }
        }
        System.out.println(sb.toString());
    }
}