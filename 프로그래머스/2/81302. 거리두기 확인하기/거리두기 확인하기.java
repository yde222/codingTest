import java.util.*;


class Solution {
    class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            result[i] = isValidRoom(places[i]) ? 1 : 0;
        }

        return result;
    }

    boolean isValidRoom(String[] place) {
        char[][] room = new char[5][5];

        // String[] → char[][] 변환
        for (int i = 0; i < 5; i++) {
            room[i] = place[i].toCharArray();
        }

        // 모든 P 위치에서 BFS 검사
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P') {
                    if (!checkDistancing(room, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    boolean checkDistancing(char[][] room, int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // 맨해튼 거리 2까지만 탐색
            if (curr.dist >= 2) continue;

            for (int i = 0; i < 4; i++) {  // 수정됨
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                // 범위 체크 추가
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    if (room[nx][ny] == 'P') {
                        return false; // 거리두기 위반!
                    }
                    if (room[nx][ny] == 'O') {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, curr.dist + 1));
                    }
                    // X(파티션)이면 해당 방향 탐색 중단 (큐에 넣지 않음)
                }
            }
        }
        return true;
    }
}