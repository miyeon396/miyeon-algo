package com.example.codete.section2arr;

import java.util.Scanner;

public class Mentoring_12 {
    // M번의 테스트 후 멘토 멘티 선발.
    // 멘토는 멘티보다 M번 모두 등수 높아야함
    // 입력 예시 4 3 \ 3 4 1 2 \ 4 3 2 1 \ 3 1 4 2 => 4명 3번시험 - 첫번째 시험 1번3등 2번4등 3번1등 4번2등
    // -> 결과 3 짝궁 케이스 3개 (3,1), (3,2), (4,2)
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        //학생별 비교 2중 포문
        //테스트 개수 포문
        //cnt 개수 포문.
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int cnt = 0;
                for(int k=0; k<m; k++) { //테스트번호
                    int pi = 0; //멘토체크
                    int pj = 0; //멘티체크
                    for(int s=0; s<n; s++) {
                        if(arr[k][s] == i) pi = s; //그학생은 몇등이다
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        Mentoring_12 T = new Mentoring_12();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
            arr[i][j] = scanner.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
        
    }
}
