import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 2배 확대
        boolean[][] border = new boolean[102][102]; // 충분한 크기

        // 1단계: 모든 직사각형의 테두리 그리기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            // 테두리만 그리기
            drawBorder(border, x1, y1, x2, y2);
        }

        // 2단계: 내부 영역 제거
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            // 내부 영역은 이동 불가
            fillInside(border, x1, y1, x2, y2);
        }

        // 3단계: BFS로 최단거리
        return bfs(border, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    void drawBorder(boolean[][] border, int x1, int y1, int x2, int y2) {
        // 4개 변을 그리기
        for (int x = x1; x <= x2; x++) {
            border[x][y1] = true; // 아래쪽 변
            border[x][y2] = true; // 위쪽 변
        }
        for (int y = y1; y <= y2; y++) {
            border[x1][y] = true; // 왼쪽 변
            border[x2][y] = true; // 오른쪽 변
        }
    }

    void fillInside(boolean[][] border, int x1, int y1, int x2, int y2) {
        // 내부 영역 제거 (테두리는 유지)
        for (int x = x1 + 1; x < x2; x++) {
            for (int y = y1 + 1; y < y2; y++) {
                border[x][y] = false;
            }
        }
    }

    int bfs(boolean[][] border, int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];

        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 &&
                    !visited[nx][ny] && border[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}

