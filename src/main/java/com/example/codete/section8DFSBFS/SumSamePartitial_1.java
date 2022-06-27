package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class SumSamePartitial_1 {
    // 합이 같은 부분집합 (DFS : 아마존 인터뷰)
    // N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 YES를 출력.
    // 그렇지 않으면 No를 출력.
    // 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어야 합니다.
    // 예를 들어 1 3 5 7 10 -> 1 3 5 7 = 6 10 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

    // 입력 예시
    // 첫 줄에 자연수 N(1<=N<=10)이 주어집니다.
    // 두번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
    // 출력 -> Yes Or No

    // ex) 6 / 1 3 5 6 7 10 -> YES

    //      D (0, 0) L, SUM
    //        o    x
    //    D(1, 1)  D(1, 0)
    //     o   x
    //  D(2,4) D(2,1) ....
    // total - sum == sum 끝.

    static String answer = "NO";
    static int n;
    static int total = 0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (L==n) {
            if((total-sum)==sum) {
                answer = "YES";
                flag = true;
            }
        } else { //이렇게 두갈래로 뻗어가다가
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        SumSamePartitial_1 T = new SumSamePartitial_1();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }

}
