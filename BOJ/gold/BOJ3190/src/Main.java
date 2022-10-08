import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[][] board;
    static Queue<Integer> time;
    static Queue<String> movingDirection;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        board = new int[N + 2][N + 2];
        for (int i = 0; i < K; i++) {
            int c = sc.nextInt();
            int r = sc.nextInt();
            board[c][r] = -2;
        }
        for (int i = 0; i < N + 2; i++) {
            board[0][i] = -1;
            board[N + 1][i] = -1;
            board[i][0] = -1;
            board[i][N + 1] = -1;
        }
        int L = sc.nextInt();


        time = new LinkedList<>();
        movingDirection = new LinkedList<>();


        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            String c = sc.next();
            time.offer(x);
            movingDirection.offer(c);
//            q.offer(new Direction(x,c)); //분리하기
        }
        int result = Solving(1, 1);
        System.out.println(result);


    }

    private static int Solving(int col, int row) {
        Stack<Place> st = new Stack<>();
        st.push(new Place(col, row));
        String status = "R";
        board[col][row] = 1;
        int snakeLen = 1;
        int timeCheck = 0;
        int changeTime = time.poll();
        while (true) {
            Place now = st.peek();
            if (now.col <= 0 || now.col >= N + 1 || now.row <= 0 || now.row >= N + 1) {
                break;
            }
            if (status.equals("R")) {

                if (board[now.col][now.row + 1] == -2) {
                    snakeLen += 1;
                }
                if (now.row + 1 < N + 1) {
                    st.push(new Place(now.col, now.row + 1));
                    board[now.col][now.row + 1] = board[now.col][now.row] + 1;
                    timeCheck++;
                } else {
                    timeCheck++;
                    break;
                }

            } else if (status.equals("L")) {
                if (board[now.col][now.row - 1] == -2) {
                    snakeLen += 1;
                }
                if (now.row - 1 > 0) {
                    st.push(new Place(now.col, now.row - 1));
                    board[now.col][now.row - 1] = board[now.col][now.row] + 1;
                    timeCheck++;
                } else {
                    timeCheck++;
                    break;
                }

            } else if (status.equals("U")) {

                if (board[now.col - 1][now.row] == -2) {
                    snakeLen += 1;
                }
                if (now.col - 1 > 0) {
                    st.push(new Place(now.col - 1, now.row));
                    board[now.col - 1][now.row] = board[now.col][now.row] + 1;
                    timeCheck++;
                } else {
                    timeCheck++;
                    break;
                }

            } else if (status.equals("D")) {

                if (board[now.col + 1][now.row] == -2) {
                    snakeLen += 1;
                }
                if (now.col + 1 < N + 1) {
                    st.push(new Place(now.col + 1, now.row));
                    board[now.col + 1][now.row] = board[now.col][now.row] + 1;
                    timeCheck++;
                } else {
                    timeCheck++;
                    break;

                }

            }
            boolean isClush=checkClushSnake(st, snakeLen);
            if(isClush==true){
                break;
            }

            if (timeCheck == changeTime) {
                if (!time.isEmpty()) {
                    changeTime = time.poll();
                } else {
                    changeTime = N + 2;
                }
                String directMode = movingDirection.poll();

                if (status.equals("R")) {
                    if (directMode.equals("D")) {
                        status = "D";

                    } else if (directMode.equals("L")) {
                        status = "U";

                    }
                } else if (status.equals("L")) {
                    if (directMode.equals("D")) {
                        status = "U";

                    } else if (directMode.equals("L")) {
                        status = "D";

                    }
                } else if (status.equals("U")) {
                    if (directMode.equals("D")) {
                        status = "R";

                    } else if (directMode.equals("L")) {
                        status = "L";

                    }

                } else if (status.equals("D")) {
                    if (directMode.equals("D")) {
                        status = "L";

                    } else if (directMode.equals("L")) {
                        status = "R";

                    }
                }
            }


        }
        return timeCheck;

    }

    private static boolean checkClushSnake(Stack<Place> st, int snakeLen) {
        Place tmp = st.peek();
        int c=tmp.col;
        int r=tmp.row;
        for(int i=1; i<=snakeLen;i++){
            if(st.size()-1-i>0){
                int cc=st.elementAt(st.size()-1-i).col;
                int cr=st.elementAt(st.size()-1-i).row;
                if(c==cc && r==cr){
                    return true;


                }
            }

        }
        return false;






    }
}

class Place {
    int col;
    int row;

    Place(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public String toString() {
        return col + " " + row;
    }
}

class Direction {
    int cnt;
    String direct;

    Direction(int cnt, String direct) {
        this.cnt = cnt;
        this.direct = direct;

    }
}