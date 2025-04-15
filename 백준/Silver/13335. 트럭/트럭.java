
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 트럭 수
        int w = Integer.parseInt(st.nextToken());  // 다리 길이
        int l = Integer.parseInt(st.nextToken());  // 최대 하중

        // 트럭 무게 입력
        Queue<Integer> waiting = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            waiting.offer(Integer.parseInt(st.nextToken()));
        }

        // 다리 위 상태 (길이 w, 처음엔 0으로 채움)
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int weightOnBridge = 0;

        while (!bridge.isEmpty()) {
            time++;

            // 다리에서 나간 트럭 무게 제거
            weightOnBridge -= bridge.poll();

            // 다음 트럭을 올릴 수 있는지 확인
            if (!waiting.isEmpty()) {
                if (weightOnBridge + waiting.peek() <= l) {
                    int nextTruck = waiting.poll();
                    bridge.offer(nextTruck);
                    weightOnBridge += nextTruck;
                } else {
                    bridge.offer(0); // 올라갈 수 없으면 빈 공간
                }
            }
        }

        System.out.println(time);
    }
}
