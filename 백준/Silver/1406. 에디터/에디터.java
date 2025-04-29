import java.io.*;

public class Main {

    static class Node {
        char data;
        Node prev;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입력/출력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기 문자열 읽기
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());

        // 더미(dummpy) head, tail 노드 생성
        Node head = new Node('\0'); // head 노드 (문자 없음)
        Node tail = new Node('\0'); // tail 노드 (문자 없음)
        head.next = tail;
        tail.prev = head;

        // 초기 문자열을 연결 리스트에 삽입
        Node cursor = tail; // 초기 커서는 맨 끝 (tail 앞)
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            insertBefore(cursor, newNode);
        }

        // 명령어 처리
        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            if (cmd == 'L') {
                if (cursor.prev != head) {
                    cursor = cursor.prev;
                }
            } else if (cmd == 'D') {
                if (cursor != tail) {
                    cursor = cursor.next;
                }
            } else if (cmd == 'B') {
                if (cursor.prev != head) {
                    remove(cursor.prev);
                }
            } else if (cmd == 'P') {
                char x = command.charAt(2);
                Node newNode = new Node(x);
                insertBefore(cursor, newNode);
            }
        }

        // 결과 출력
        Node current = head.next;
        while (current != tail) {
            bw.write(current.data);
            current = current.next;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // cursor 앞에 새 노드를 삽입하는 메소드
    private static void insertBefore(Node cursor, Node newNode) {
        Node prevNode = cursor.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = cursor;
        cursor.prev = newNode;
    }

    // 주어진 노드를 삭제하는 메소드
    private static void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
