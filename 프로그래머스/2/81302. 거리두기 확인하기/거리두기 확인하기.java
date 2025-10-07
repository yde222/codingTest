import java.util.*;

class Solution {
    class Point {
        int x, y, dist;
        
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
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
    
    private boolean isValidRoom(String[] place) {
        char[][] room = new char[5][5];
        for (int i = 0; i < 5; i++) {
            room[i] = place[i].toCharArray();
        }
    
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

    private boolean checkDistancing(char[][] room, int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
 
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.dist >= 2) {
                continue;
            }
 
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (isInBounds(nx, ny) && !visited[nx][ny]) {
                    
                    if (room[nx][ny] == 'P') {
                        return false;
                    }
                    
                    if (room[nx][ny] == 'O') {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, curr.dist + 1));
                    }
            }
        }
        }
        return true; 
    }
    
    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
    
}
