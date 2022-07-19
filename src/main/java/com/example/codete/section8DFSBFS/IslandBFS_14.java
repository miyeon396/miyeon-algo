package com.example.codete.section8DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandBFS_14 {
    // 섬나라 아일랜드
    // N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집
    // 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다
    // 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램 작성
    // ex)
    // 1 1 0 0 0 1 0
    // 0 1 1 0 1 1 0
    // 0 1 0 0 0 0 0
    // 0 0 0 1 0 1 1
    // 1 1 0 1 1 0 0
    // 1 0 0 0 1 0 0
    // 1 0 1 0 1 0 0
    // 만약위와 같다면 섬의 개수는 5개

    // 입력설명
    // 첫 번째 줄에 자연수 (3<=N<=20)이 주어짐
    // 두번째 줄부터 격자판 정보가 주어짐

    // 출력 설명
    // 첫 번째 줄에 섬의 개수 출력
    // ex) 7 /
    // 1 1 0 0 0 1 0
    // 0 1 1 0 1 1 0
    // 0 1 0 0 0 0 0
    // 0 0 0 1 0 1 1
    // 1 1 0 1 1 0 0
    // 1 0 0 0 1 0 0
    // 1 0 1 0 1 0 0
    // -> 5

    static int answer = 0;
    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //8방향 시계 방향으로
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<IslandPoint> queue = new LinkedList<IslandPoint>();

    public static void BFS(int x, int y, int[][] board) {
        queue.add(new IslandPoint(x, y));

        while(!queue.isEmpty()) {
            IslandPoint pos = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] ==1) {
                    board[nx][ny] = 0;
                    queue.add(new IslandPoint(nx, ny));
                }
            }
        }
    }

    public static void solution(int[][] board) {
        // 2중 포문이 돌면서 섬을 만날때마다 DFS 호출
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(board[i][j]==1) {
                    answer++;
                    board[i][j]=0; // 출발점을 0으로 바꿔 놓고
                    BFS(i,j,board);
                }
            }
        }
    }

    public static void main(String[] args) {
        IslandBFS_14 T = new IslandBFS_14();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = scanner.nextInt();;
            }
        }
        solution(arr);
        System.out.println(answer);

    }

}

class IslandPoint {
    int x;
    int y;
    IslandPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}