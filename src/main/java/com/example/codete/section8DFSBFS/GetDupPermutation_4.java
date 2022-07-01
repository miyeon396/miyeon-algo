package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class GetDupPermutation_4 {
    // 중복순열 구하기
    // 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력
    // 입력 설명
    // 첫 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어짐
    // 출력 설명
    // 첫 줄에는 결과 출력. 출력 순서는 사전순으로 오름차순으로 출력

    // ex) 3 2 -> 1 1 / 1 2 / 1 3 / 2 1 / 2 2 / 2 3 / 3 1
    // 중복순열은 N번 일어남.




    static int[] pm;
    static int n;
    static int m;

    public void DFS(int L) {
        if(L==m) {
            for(int x: pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++) {
                pm[L] = i;
                DFS(L+1); // -> 뻗어 나가는 부분
            }
        }
    }

    public static void main(String[] args) {
        GetDupPermutation_4 T = new GetDupPermutation_4();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 문제 개수
        m = scanner.nextInt(); // 제한 시간
        pm = new int[m];
        T.DFS(0);
    }

}
