import java.util.*;

class Solution {
        public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int k : scoville){
            minHeap.offer(k);
        }

        int mixCount = 0;

        while(minHeap.size() > 1&& minHeap.peek() < K){

            int a = minHeap.poll();
            int b = minHeap.poll();

            int mix = a + b*2;

            minHeap.offer(mix);
            mixCount++;
        }

        return minHeap.peek()>= K ? mixCount: -1;


    }
}