import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 복사 : visited[화면의 이모티콘 수][화면의 이모티콘 수]를 확인한다. 복사를 수행했을 경우 이전 꺼는 덮어씌워지기 때문에 화면의 이모티콘 수와 클립보드의 이모티콘 수가 같아진다.
 * 붙혀넣기 : visited[화면의 이모티콘 수+클립보드의 이모티콘 수][클립보드의 이모티콘 수]를 확인한다. 붙혀넣기를 수행하면 화면 이모티콘 수에 클립보드 이모티콘 개수가 더해진다.
 * 삭제 : visited[화면의 이모티콘 수-1][클립보드의 이모티콘 수]를 확인한다.
 *
 * */
public class Main {
    static int minTime = (int) 1e9;
    static int[][] visited;

    public static void main(String[] args) {
        int clipboard = 0;
        int screen = 1;
        visited = new int[2001][2001];// 행: 화면 이모티콘의 개수, 열:클립보드 이모티콘 개수
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BFS(screen, clipboard, N);
        System.out.println(minTime);


    }

    private static void BFS(int screen, int clipboard, int N) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{screen, 0, clipboard});

        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();

            int cntScreen = now[0];
            int time = now[1];
            int cntClipboard = now[2];

            if (cntScreen == N) {
                minTime = Math.min(minTime, time);
            }

            if (cntScreen > 0 && cntScreen < 2000 && visited[cntScreen][cntScreen] == 0) { //화면내용 모두 복사
                dq.offer(new int[]{cntScreen, time + 1, cntScreen});
                visited[cntScreen][cntScreen] = 1;

            }
            if (cntScreen -1 >= 0 && visited[cntScreen - 1][cntClipboard] == 0) { //화면 내용 1개 삭제하기
                dq.offer(new int[]{cntScreen - 1, time + 1, cntClipboard});
                visited[cntScreen - 1][cntClipboard] = 1;

            }
            if (cntClipboard > 0 && cntScreen + cntClipboard < 2000 && visited[cntScreen + cntClipboard][cntClipboard] == 0) { //클립보드내용 모두 붙여넣기

                dq.offer(new int[]{cntScreen + cntClipboard, time + 1, cntClipboard});
                visited[cntScreen + cntClipboard][cntClipboard] = 1;

            }


        }

    }
}