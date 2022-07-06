package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class EstimateMathArr_8 {
    // 수열 추측하기
    // 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘 째 줄부터 차례대로 파스칼의 삼각형 처럼 위의 두개를 더한 값이 저장되게 된다.
    // 예를 들어 N이 4이고 가장 윗 줄에 3 1 2 4가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
    // 3 1 2 4
    //  4 3 6
    //   7 9
    //    16
    // N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오. 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
    // 입력 설명
    // 첫째 줄에 두개의 정수 N(1<N<10)과 E가 주어진다. N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1000000이하이다.
    // 출력 설명
    // 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸 사이에 두고 출력한다. 답이 존재 하지 않는 경우는 입력으로 주어지지 않는다.
    // ex) 4 16 -> 3 1 2 4

    // 순열 구하기로 풀면됨!!?!
    // 사진
    // 3 + 1 + 1 + 1 + 2 + 2 + 2 + 4
    // 3C0 + 3C1 + 3C2 + 3C3


    static int[] b;
    static int[] p;
    static int[] ch; // 중복 순열이 아니니 check 배열 필요

    static int n; // 입력 숫자 개수
    static int f; // final number
    boolean flag = false;
    int[][] dy = new int[35][35]; //조합 수 메모이제이션 하려구
    public int combi(int n, int r) {
        if (dy[n][r]>0) return dy[n][r];
        if (n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) {
            return;
        }
        if (L == n) { //순열이 하나가 완성 되었을 때 final number와 같은지 체크
            if (sum==f) {
                for (int x : p) {
                    System.out.print(x+ " ");
                    flag = true;
                }
            }

        } else { //순열을 만들기. i라는 숫자가 순열을 만드는 숫자.
            for (int i=1; i<= n; i++) {
                if (ch[i] == 0) { //i는 인덱스가 아님 숫자임.
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        EstimateMathArr_8 T = new EstimateMathArr_8();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // 4
        f = scanner.nextInt(); // 16
        b = new int[n];
        p = new int[n];
        ch = new int[n+1]; // 체크를 1부터 해서
        for (int i=0; i<n; i++) {
            b[i] = T.combi(n-1, i);
        }
        T.DFS(0,0);
    }

}
