package com.example.codete.section2arr;

import java.util.Scanner;

public class MountinPeak_10 {
    //봉우리 문제
    //격자판 주어짐. 상하좌우보다 큰 숫자는 봉우리 지역. 봉우리지역이 몇개 있는지 알아내는 방법.
    //격자의 가장자리는 0으로 초기화 되었다고 가정.
    //n = 5이고 격자판 숫자가 다음과 같다면 봉우리 개수는 10개.
    // 0 0 0 0 0 0 0
    // 0 5 3 7 2 3 0
    // 0 3 7 1 6 1 0
    // 0 7 2 5 3 4 0
    // 0 4 3 6 4 1 0
    // 0 8 7 3 5 2 0
    // 0 0 0 0 0 0 0
    int[] dx = {-1, 0, 1, 0}; // 행 움직이는거
    int[] dy = {0, 1, 0, -1}; //열 움직이는거 -> 12시 3시 6시 9시 조회 위해서 (메인이 접근하지 않고 솔루션만 접근하니 static선언 안함)

    public int solution(int n, int[][] arr) {
        //2차원 배열 에서 12시 3시 6시 9시 조사해서 나보다 큰거 보다 같다면 패스 없다면 내가 봉우리.
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boolean flag = true;//봉오리니 아니니
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) { //nx >= 0 && nx < n && ny >= 0 && ny < n 경계선 걸러내는 조건
                        flag = false;
                        break; // 하나라도 있으면 봉우리 아님.
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MountinPeak_10 T = new MountinPeak_10();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
        
    }
}
