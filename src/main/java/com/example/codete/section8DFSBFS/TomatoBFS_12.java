package com.example.codete.section8DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBFS_12 {
    // 토마토(BFS활용)
    // 토마토 농장에서 토마토 보관하는 큰 창고 갖고있고 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관

    // 창고 보관중 토마토 중 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면 익은 토마토들의 인접한 곳에 있는 안익은 토마토가 익은 토마토 영향받아 익게됨.
    // 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미
    // 대각선 방향에 있는 토마토들에게 영향을 주지 못하며 토마토가 혼자 저절로 익는 경우는 없다고 가정
    // 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶음.
    // 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 떄,
    // 며칠이 지나면 토마토가 모두 익는지 그 최소일수를 구하는 프로그램 작성
    // 단, 일부 칸에 토마토가 들어있지 않을 수도 있다.

    // 읿력
    // 첫줄에 상자 크기 나타내는 M,N.
    // M은 상자 가로칸의 수 N은 상자 세로 칸의 수 2<=M, N<=1000
    // 둘째 줄부터 하나의 상자에 저장된 토마토 정보제공. 1은 익은 토마노, 0은 안익은 토마토, -1은 빈곳

    // 출력
    // 토마토가 모두 익을때까지의 최소날짜. 저장될 때부터 모든 토마토가 익어잇는 상태면 0. 토마토가 모두 익지 못하는 상황이면 -1 출력

    // ex)
    // 6 4 -> 4행 6열
    // 0 0 -1 0 0 0
    // 0 0 1 0 -1 0
    // 0 0 -1 0 0 0
    // 0 0 0 0 -1 1
    // -> 4

    // 시작이 1 동시 다발적으로 퍼져 나감. 큐에 1이 되는순간 몇컴마몇인지를 입력해놓음. 1,2 3,5를 BFS 돌기 전에 넣어둠.
    // 1,2 뽑아서 12시3시6시9시 보구 0인애들 1로 바꾸고 1,3을 다시 큐에 넣어줌 날수 배열에는 몇날인지 세줌
    // 다시 1,3 이제 뽑아서 시작


    static int[] dx = {-1, 0, 1, 0}; //9시 12시 3시 6시...
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dis;
    static int n; //행
    static int m; //열
    static Queue<Point> Q = new LinkedList<>();

    public void BFS() {
        // 하나 꺼내서 네방향. 체크 걸고 dis에 넣고
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }

    }

    public static void main(String[] args) {
        TomatoBFS_12 T = new TomatoBFS_12();
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        board = new int[n][m];
        dis = new int [n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 1) {
                    Q.offer(new Point(i,j)); //출발점이 여러개니 미리 넣어둬라
                }
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 0) {
                    flag = false; // 익지 않은 토마토가 있는 경우
                }
            }
        }
        if(flag) { // 다 익었다면
            for(int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    answer = Math.max(answer, dis[i][j]); //dis에서 최댓값(걸린최대일) 출력
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

}
