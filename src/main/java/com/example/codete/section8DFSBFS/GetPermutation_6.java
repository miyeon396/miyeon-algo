package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class GetPermutation_6 {
    // 순열 구하기
    // 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력

    // 입력 설졍
    // 첫 줄에 자연수(3<=N<=10)과 M(2<=M<=N)이 주어짐
    // 두 줄에 N개의 자연수가 오름차순으로 주어짐
    // 출력 첫줄에 결과 출력. 순서는 사전순으로 오름차순

    // ex) 3 2 / 3 6 9 -> 3 6 / 3 9 / 6 3 / 6 9 / 9 3 / 9 6
    // 중복이 안되니 ch[i]==0이 일 때만 넣어줌

    static int[] pm; //순열의 결과 넣음 ex ) 3 6 / ...
    static int[] ch; //체크배열
    static int[] arr; //입력된 숫자
    static int n; // 숫자 개수
    static int m; // 몇개를 뽑는다

    public void DFS(int L) {
        if(L==m) {
            for (int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for (int i=0; i<n; i++) {
                if (ch[i] == 0) {
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0; // 체크를 풀 어줘야함
                }
            }
        }
    }

    public static void main(String[] args) {
        GetPermutation_6 T = new GetPermutation_6();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        ch = new int[n]; // 숫자 별로 체크해야하니 숫자 개수 넣어줌
        pm = new int[m]; // 결과 넣어야하니 몇개 뽑는지의 m 넣어줌
        T.DFS(0);
    }

}
