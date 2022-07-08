package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class SearchMaze_10 {
    // 미로 탐색 (DFS)
    // 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램 작성
    // 출발점은 격자의 (1,1) 좌표이고 탈출 도착점은 (7,7) 좌표이다. 격자판의 1은 벽이고, 0은 통로다.
    // 격자는 상하좌우만 움직임
    // 출 0 0 0 0 0 0
    // 0 1 1 1 1 1 0
    // 0 0 0 1 0 0 0
    // 1 1 0 1 0 1 1
    // 1 1 0 0 0 0 1
    // 1 1 0 1 1 0 0
    // 1 0 0 0 0 0 도착
    // 위의 지도에서 출발부터 도착까지 가는법은 8개다
    // 격자판 입력 시 경로 가지수 출력
    // ex)
    // 0 0 0 0 0 0 0
    // 0 1 1 1 1 1 0
    // 0 0 0 1 0 0 0
    // 1 1 0 1 0 1 1
    // 1 1 0 0 0 0 1
    // 1 1 0 1 1 0 0
    // 1 0 0 0 0 0 0
    // -> 8

    // 간길을 1로 바꾸면서 가라 12시 3시 6시 9시 방향으로 가면서 x==7, y==7 이면 ++ 하고 체크했던 1들 빽하면서 다 풀어줌
    // 4방향으로 갈 수 있을 때 가고 갓다면 빽해주고 종착지 오면 카운트 해주면 된다 심플하게 ㅎㅎ

    static int[] dx = {-1, 0, 1, 0}; //9시 12시 3시 6시...
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y) {
        if(x==7 && y==7) { // 종착지 온거
            answer++;
        } else {
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if( nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SearchMaze_10 T = new SearchMaze_10();
        Scanner scanner = new Scanner(System.in);
        board = new int[8][8];
        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        board[1][1] = 1;
        T.DFS(1,1);
        System.out.println(answer);
    }

}
