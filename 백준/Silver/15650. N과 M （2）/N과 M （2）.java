import java.util.Scanner;

public class Main {
    public static int N, M;
    public static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M];

        backtrack(0, 1); // 시작 인덱스 0, 숫자는 1부터 시작
    }
    public static void backtrack(int depth, int start) {
        if (depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(selected[i]+ " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            backtrack(depth + 1, i + 1);
        }
    }

}