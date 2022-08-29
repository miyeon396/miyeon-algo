package com.example.codete.section10DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ExchangeCoins_5 {
    // 동전 교환 알고리즘 (냅색 알고리즘)
    // 다음과 같이 여러 단위의 동전들이 주어져 있을 때, 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    // 각 단위의 동전은 무한정 쓸 수 있다.
    // 입력
    // 첫줄에 동전 종류 개수 / 두번째 줄에 N개의 동전의 종류 / 그 다음줄에 거슬러 줄 금액
    // 각 동전의 종류는 100원을 넘지 않는다.
    // 출력
    // 거슬러 줄 동전의 최소 개수

    // ex) 3 / 1 2 5 / 15 -> 3

    // dy[i] : i 금액을 만드는데 드는 최소 동전 개수

    static int n;
    static int m;
    static int[] dy;
    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE); //dy라는 배열을 큰 수로 초기화
        dy[0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=coin[i]; j<=m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String args[]) {
        ExchangeCoins_5 T = new ExchangeCoins_5();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt(); //동전의 단위들을 받음
        }
        m = scanner.nextInt(); // 거슬러줄 금액 m
        dy = new int[m+1];
        System.out.println(T.solution(arr));

    }

    static class Brick implements Comparable<Brick> {

        public int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s; //s에의한 내림차순
        }
    }

}

