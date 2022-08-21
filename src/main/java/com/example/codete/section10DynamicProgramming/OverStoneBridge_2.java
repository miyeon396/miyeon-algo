package com.example.codete.section10DynamicProgramming;

import java.util.Scanner;

public class OverStoneBridge_2 {
    // 돌다리 건너기
    // 학교가다가 개울 만남
    // 개울은 N개의 돌로 다리를 만들어 놓음
    // 돌다리를 건널 때 한번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있음.
    // 개울을 건너는 방법은 몇가지?

    // 개울을 건너는 거지만 계단과 유사. 다이나믹 사용
    // 한가지 주의점은 돌다리는 마지막 한번이 추가됨.

    // ex) 7 -> 34

    // 다이나믹 -> 작은 문제로 변환 시키는 것.

    static int[] dy;
    public int solution(int n) {
        dy[1] = 1; //1번째 계단까지 가는 방법의 수
        dy[2] = 2;

        for(int i=3; i<=n+1; i++) { //n+1까지 돌아야함 목적지는 +1 이니까
            dy[i] = dy[i-2]+dy[i-1];
        }
        return dy[n+1];

    }

    public static void main(String args[]) {
        OverStoneBridge_2 T = new OverStoneBridge_2();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n+2];
        System.out.println(T.solution(n));

    }
}
