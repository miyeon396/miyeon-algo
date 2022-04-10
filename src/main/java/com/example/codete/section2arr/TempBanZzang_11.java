package com.example.codete.section2arr;

import java.util.Scanner;

public class TempBanZzang_11 {
    //임시 반장 정하기. 임시 이후 추후 정식선거.
    //자기반 학생 중 1학년부터 5학년까지 지내오면서 한번이라도 같은반이었던 사람이 제일 많은 학생 임시반장
    // 학생들이 학년별로 속했던 반을 쓴 것.
    // 예) 1학년 2학년 3학년 4학년 5학년
    // 1번학생 2 3 1 7 3
    // 2번 4 1 9 6 8
    // 3번 5 5 2 4 4
    // 4번 6 5 2 6 7
    // 5번 8 4 2 2 2
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            int cnt = 0; //i번 학생과 같은반 햇던 j번 학생은 몇명 있는가
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=5; k++) { //반 돌림
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break; //한번만 같은 반 되었으면 걍 한번 카운트 하고 끝내는 것이기 때문에
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }


        return answer;
    }

    public static void main(String args[]) {
        TempBanZzang_11 T = new TempBanZzang_11();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n+1][6]; //1번부터 사용할거라 / 6학년까지 생길꺼라
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
        
    }
}
