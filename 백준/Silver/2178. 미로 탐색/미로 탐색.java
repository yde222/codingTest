import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {-1, 1, 0, 0,};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();  // 한 줄 입력
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);

    }


    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = now[0] + di[k];
                int j = now[1] + dj[k];
                if (i >= 0 && j >= 0 && i < N && j < M) {
                    if (A[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        A[i][j] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{i, j});  // 현재 이동한 위치를 넣어야 함

                    }
                }
            }
        }
    }
}