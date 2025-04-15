import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static class Ballon {
        int order;       // 풍선 번호
        int noteValue;   // 이동 값

        public Ballon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Deque<Ballon> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(input[i]);
            deque.addLast(new Ballon(i + 1, value));
        }

        StringBuilder result = new StringBuilder();

        while (!deque.isEmpty()) {
            Ballon current = deque.pollFirst();
            result.append(current.order).append(" ");

            if (deque.isEmpty()) break;

            int move = current.noteValue;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(result.toString().trim());
    }
}
