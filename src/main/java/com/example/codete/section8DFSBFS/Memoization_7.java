package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class Memoization_7 {
    // 조합의 경우수(메모이제이션)
    // nCr = n! / (n-r)!r!로 계산합니다. 하지만 여러분은 이 공식을 쓰지 않고 다음 공식을 사용하여 재귀를 이요해 조합수를 구해주는 프로그램을 작성
    // nCr = n-1Cr-1+n-1Cr
    // 입력 설명
    // 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
    // 출력 설명
    // 첫째 줄에 조합수 출력
    // ex) 5 3 -> 10 , 33 19 -> 818809200
    // 재귀니까 2가닥으로 뻗음  5C3 = 4C2 + 4C3 ...

    public int DFS(int n, int r) {
        if (n==r || r==0) {
            return 1;
        } else {
            return DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Memoization_7 T = new Memoization_7();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(T.DFS(n, r));
    }

}
