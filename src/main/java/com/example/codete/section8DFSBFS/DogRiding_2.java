package com.example.codete.section8DFSBFS;

import java.util.Scanner;

public class DogRiding_2 {
    // 바둑이 승차 (DFS)
    // 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C키로가 넘게 태울 수없다.
    // 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
    // N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램

    // 첫줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어짐.
    // 둘째 줄부터 N마리의 바둑이의 무게가 주어짐.
    // -> 첫줄에 가장 무거운 무게를 출력
    // ex) 295 5 / 81 58 42 33 61 -> 242

    // -> 부분 집합이네 앞전 코드와 똑같네?
    // {81, 58, 42, 33, 61} // -> 1번 바둑이를 트럭에 태운다 태우지 않는다 -> D(L, Sum) sum=트럭에 타는 바둑이의 무게 / sum>c return;



    static int answer = Integer.MIN_VALUE; // 최대 무게를 찾아야 하니까 가장 작은 값.
    static int c;
    static int n;

    public void DFS(int L, int sum, int[] arr) {
        if (sum > c) {
            return;
        }

        if (L==n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }

    }

    public static void main(String[] args) {
        DogRiding_2 T = new DogRiding_2();
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt(); //무게
        n = scanner.nextInt(); //마리수
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }

}
